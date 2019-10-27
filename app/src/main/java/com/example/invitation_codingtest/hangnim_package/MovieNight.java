package com.example.invitation_codingtest.hangnim_package;

import java.util.*;
import java.text.SimpleDateFormat;

public class MovieNight {

    public static Boolean canViewAll(ArrayList<Movie> movies) {
        for (int x = 1; x <= movies.size(); x++){
            for (int y = 1; y <= movies.size(); y++){
                if (y != x){
//                    if (overlapchecker(movies.get(x),movies.get(y)))
//                    {
//                        return false;
//                    }

                    if (isOverlapping(movies.get(x).getStart(),movies.get(x).getEnd(), movies.get(y).getStart(), movies.get(y).getEnd())){
                        return false;
                    }
                }
            }
        }
        return true;

    }

    public static boolean isOverlapping(Date start1, Date end1, Date start2, Date end2) {
        return start1.before(end2) && start2.before(end1);
    }

    public static boolean overlapchecker(Movie date1, Movie date2) {
        boolean checker = date1.getStart().before(date2.getEnd()) && date2.getStart().before(date1.getEnd());
        return checker;
    }


    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));

        System.out.println(MovieNight.canViewAll(movies));
    }
}

class Movie {
    private Date start, end;

    public Movie(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }
}