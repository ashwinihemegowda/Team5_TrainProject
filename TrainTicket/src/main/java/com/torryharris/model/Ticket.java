package com.torryharris.model;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Ticket {

    //Attributes Of Ticket Class
    private int counter=100;
    private String pnr;
    private Date travelDate;
    private Train train;
    private TreeMap<Passenger, Integer> passengers = new TreeMap<>();
    public Ticket() {
    }

    //Parameterized Constructor
    public Ticket(Date travelDate, Train train) {
        this.travelDate = travelDate;
        this.train = train;
    }

    //Getters and Setters For Ticket Class
    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }
    public String getPnr() {
        return pnr;
    }
    public void setPnr(String pnr) {
        this.pnr = pnr;
    }
    public Date getTravelDate() {
        return travelDate;
    }
    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }
    public Train getTrain() {
        return train;
    }
    public void setTrain(Train train) {
        this.train = train;
    }
    public TreeMap<Passenger, Integer> getPassengers() {
        return passengers;
    }
    public void setPassengers(TreeMap<Passenger, Integer> passengers) {
        this.passengers = passengers;
    }


    //Method to Generate PNR
    private String generatePNR() {
        char src = train.getSource().charAt(0);
        char desc = train.getDestination().charAt(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String date = simpleDateFormat.format(travelDate);
        String pnr = "" + src + "" + desc + "_" + date + "_" + counter;
        return pnr;
    }

    //Method to calcPassengerFare
    private double calcPassengerFare(Passenger passenger) {
        double ticketPrice = train.getTicketPrice();
        int age = passenger.getAge();
        char gender = passenger.getGender();
        if (age >= 60) {
            ticketPrice = ticketPrice * 0.4;
            return ticketPrice;
        } else if (gender == 'F') {
            ticketPrice = ticketPrice * 0.75;
            return ticketPrice;
        } else if (age <= 12) {
            ticketPrice = ticketPrice * 0.5;
            return ticketPrice;
        } else
            return ticketPrice;
    }

    //Method to calculate Total Ticket Price
    private double calculateTotalPrice() {
        double totalTicketPrice = 0;
        for (Passenger p : passengers.keySet()) {
            totalTicketPrice += passengers.get(p);
        }
        return totalTicketPrice;
    }

    //Method to Generate Ticket
    private StringBuilder generateTicket() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy");
        String date = simpleDateFormat.format(travelDate);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PNR:        " + generatePNR() + "\n");
        stringBuilder.append("Train No:   " + getTrain().getTrainNo() + "\n");
        stringBuilder.append("Train Name: " + getTrain().getTrainName() + "\n");
        stringBuilder.append("From:       " + getTrain().getSource() + "\n");
        stringBuilder.append("To:         " + getTrain().getDestination() + "\n");
        stringBuilder.append("Travel Date:" + date + "\n");
        stringBuilder.append("Passenger: " + "\n");
        stringBuilder.append("\n");
        stringBuilder.append("Name\t\tage\t\tGender\t\tFare\n");
        for(Map.Entry<Passenger,Integer>pie:passengers.entrySet())
        {
            stringBuilder.append(pie.getKey().getName()+"\t\t"+pie.getKey().getAge()+"\t\t"+pie.getKey().getGender()
                    +"\t\t"+pie.getValue()+"\t\t\n");
        }
        stringBuilder.append("TotalPrice: " + calculateTotalPrice());
        return stringBuilder;
    }

    //Method to Add Passenger
    public void addPassenger(String name, int age, char gender) {
        Passenger passenger = new Passenger(name, age, gender);
        double price = calcPassengerFare(passenger);
        passengers.put(passenger, (int) price);
    }

    //Method To Write Ticket To File
    public void writeTicket() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(generatePNR() +".txt");
        StringBuilder stringBuilder = this.generateTicket();
        fileOutputStream.write(stringBuilder.toString().getBytes());
        fileOutputStream.close();
        System.out.println(this.generatePNR());
    }


    //To String
    @Override
    public String toString() {
        return "Ticket{" +
                "counter=" + counter +
                ", pnr='" + pnr + '\'' +
                ", travelDate=" + travelDate +
                ", train=" + train +
                ", passengers=" + passengers +
                '}';
    }
}
