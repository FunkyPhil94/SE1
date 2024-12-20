package org.hbrs.se1.ws24.exercises.uebung8;



import java.util.ArrayList;
import java.util.List;



//    BEISPIELKLASSE
public class ReiseAnbieterAdapter {

    private ReiseAnbieter reiseAnbieter;

    public ReiseAnbieterAdapter(ReiseAnbieter reiseAnbieter) {
        this.reiseAnbieter = reiseAnbieter;
    }

    public List<SuchErgebnis> sucheHotels(SuchAuftrag auftrag) {
        QueryObject queryObject = transformiereSuchAuftrag(auftrag);
        QueryResult queryResult = reiseAnbieter.executeQuery(queryObject);
        return transformiereSuchErgebnis(queryResult);
    }

    private QueryObject transformiereSuchAuftrag(SuchAuftrag auftrag) {
        System.out.println("Transformiere SuchAuftrag zu QueryObject");
        return new QueryObject(auftrag.getStartDatum(), auftrag.getEndDatum(), auftrag.getOrt());
    }

    private List<SuchErgebnis> transformiereSuchErgebnis(QueryResult queryResult) {
        System.out.println("Transformiere QueryResult zu List<SuchErgebnis>");
        List<SuchErgebnis> ergebnisse = new ArrayList<>();

        for (HotelInformation hotelInfo : queryResult.getResults()) {
            ergebnisse.add(new SuchErgebnis(hotelInfo.hotelName, hotelInfo.pricePerNight));
        }

        return ergebnisse;
    }
}
