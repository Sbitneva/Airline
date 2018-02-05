package sbitneva.dao;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sbitneva.dao.xml.XmlValidator;
import sbitneva.entity.aircrafts.Aircraft;
import sbitneva.entity.aircrafts.AircraftFactory;
import sbitneva.entity.aircrafts.Cargos;
import sbitneva.entity.aircrafts.Passengers;
import sbitneva.entity.aircrafts.internal.Cargo;
import sbitneva.entity.aircrafts.internal.Passenger;
import sbitneva.entity.airline.Airline;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static sbitneva.dao.xml.AirlineXmlConstants.*;


class AirlineXmlDao implements AirlineDao {

    private static final String SCHEMA_PATH = "xml/airline.xsd";
    private static final String XML_DATA_PATH = "xml/airline.xml";
    private static Logger log = Logger.getLogger(AirlineXmlDao.class.getName());

    @Override
    public void loadAircrafts() {
        Document document = loadDocument();
        Element root = document.getDocumentElement();
        Airline airline = Airline.getAirline();
        if (root.getTagName().equals(ROOT)) {
            NodeList aircraftNodeList = root.getElementsByTagName(AIRCRAFT);
            int listSize = aircraftNodeList.getLength();
            log.debug("aircrafts amount = " + listSize);
            for (int i = 0; i < listSize; i++) {
                Element aircraftElement = (Element) aircraftNodeList.item(i);
                Element typeElement = (Element) aircraftElement.getElementsByTagName(AIRCRAFT_TYPE).item(0);

                String type = typeElement.getElementsByTagName(TYPE).item(0).getTextContent();
                Aircraft aircraft = AircraftFactory.getAircraft(type);

                if (aircraft instanceof Cargos) {
                    loadCargos((Cargos) aircraft, typeElement);
                } else if (aircraft instanceof Passengers) {
                    loadPassengers((Passengers) aircraft, typeElement);
                }
                loadBasicData(aircraft, aircraftElement);
                airline.addAircraft(aircraft);
                log.debug("aircraft #" + i + " loaded: " + aircraft);
            }
        }
    }

    private void loadBasicData(Aircraft aircraft, Element aircraftElement) {
        aircraft.setId(aircraftElement.getElementsByTagName(ID).item(0).getTextContent());
        aircraft.setName(aircraftElement.getElementsByTagName(NAME).item(0).getTextContent());
        aircraft.setCapacity(Integer.parseInt(aircraftElement.getElementsByTagName(CAPACITY).item(0).getTextContent()));
        aircraft.setFlightRange(Integer.parseInt(aircraftElement.getElementsByTagName(FLIGHT_RANGE).item(0).getTextContent()));
        aircraft.setFuelConsumption(Integer.parseInt(aircraftElement.getElementsByTagName(FUEL_CONSUMPTION).item(0).getTextContent()));
    }

    private void loadCargos(Cargos aircraft, Element typeElement) {

        NodeList cargosListElement = typeElement.getElementsByTagName(CARGO);
        int cargosListSize = cargosListElement.getLength();
        for (int i = 0; i < cargosListSize; i++) {
            Cargo cargo = new Cargo();
            Element cargoItem = (Element) cargosListElement.item(i);
            cargo.setId(cargoItem.getElementsByTagName(CARGO_ID).item(0).getTextContent());
            cargo.setCargoWeight(Integer.parseInt(
                    cargoItem.getElementsByTagName(CARGO_WEIGHT).item(0).getTextContent()));
            aircraft.addCargo(cargo);
        }
    }

    private void loadPassengers(Passengers aircraft, Element typeElement) {

        NodeList passListElement = typeElement.getElementsByTagName(PASSENGER);
        int passListSize = passListElement.getLength();
        for (int i = 0; i < passListSize; i++) {
            Passenger passenger = new Passenger();
            Element passengerItem = (Element) passListElement.item(i);
            passenger.setFirstName(passengerItem.getElementsByTagName(FIRST_NAME).item(0).getTextContent());
            passenger.setLastName(passengerItem.getElementsByTagName(LAST_NAME).item(0).getTextContent());
            passenger.setLuggageWeight(Integer.parseInt(
                    passengerItem.getElementsByTagName(LUGGAGE_WEIGHT).item(0).getTextContent()));
            aircraft.addPassenger(passenger);
        }
    }

    private Document loadDocument() {
        Document document = null;

        boolean isValid = XmlValidator.validateAccordingToSchema(SCHEMA_PATH, XML_DATA_PATH);
        if (isValid) {
            DocumentBuilderFactory dbf;
            try {
                dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                try {
                    document = db.parse(new File(XML_DATA_PATH));
                    log.debug("Document from file " + SCHEMA_PATH + " is created");

                } catch (IOException | SAXException e) {
                    log.error("Document from file " + SCHEMA_PATH + " doesn't created " + e.getMessage());
                }
            } catch (ParserConfigurationException e) {
                log.error("DocumentBuilder exception" + e.getMessage());
            }
        }
        return document;
    }
}
