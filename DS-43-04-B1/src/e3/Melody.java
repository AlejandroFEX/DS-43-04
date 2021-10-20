package e3;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Objects;

public class Melody {

    public enum Notes{
        DO, RE, MI, FA, SOL, LA, SI
    }
    public enum Accidentals{
        SHARP, FLAT,NATURAL
    }
    ArrayList<Notes> notes = new ArrayList<>();
    ArrayList<Accidentals> accidentals = new ArrayList<>();
    ArrayList<Float> times= new ArrayList<>();
    /**
     * Creates an empty Melody instance .
     */
    public Melody () { /* ... */ }
    /**
     * Add a note at the end of this melody .
     * @param note The note to add
     * @param accidental The accidental of the note
     * @param time The duration of the note in milliseconds
     * @throws IllegalArgumentException if the note , the accidental
     * or the time are not valid values .
     */
    public void addNote ( Notes note , Accidentals accidental , float time ) {
        if (note == null || accidental == null || time == 0) {
        throw new IllegalArgumentException();

    } else {
        notes.add(note);
        accidentals.add(accidental);
        times.add(time);
        }
    }
    /**
     * Returns the note on the given position
     * @param index The position of the note to get .
     * @return The note on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */

    public Notes getNote ( int index ) {
        if (index>=notes.size())
            throw new IllegalArgumentException();
        return notes.get(index);
    }
    /**
     * Returns the accidental of the note on the given position
     * @param index The position of the accidental to get .
     * @return The accidental on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public Accidentals getAccidental (int index ) {
        if (index>=accidentals.size())
            throw new IllegalArgumentException();
        return accidentals.get(index);
    }
    /**
     * Returns the duration of the note on the given position
     * @param index The position of the time to get .
     * @return The time on index .
     * @throws IllegalArgumentException if the index is not a valid position .
     */
    public float getTime ( int index ) {
        if (index>=times.size())
            throw new IllegalArgumentException();
        return times.get(index);
    }
    /**
     * Returns the number of notes in this melody .
     * @return The number of notes in this melody .
     */
    public int size () {
        return notes.size();
    }
    /**
     * Returns the duration of this melody .
     * @return The duration of this melody in milliseconds .
     */
    public float getDuration () {
       float duracion=0;
        for (Float time : times) {
            duracion = duracion + time;
        }
        return duracion;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Melody melody = (Melody) o;

        if(Objects.equals(notes, melody.notes) &&
                Objects.equals(accidentals, melody.accidentals) &&
                Objects.equals(times, melody.times))
            return true;
        else{
            if (!Objects.equals(times, melody.times)){
                return false;
            }
            boolean a =false;
            for (int i=0;i<notes.size();i++){
                if(notes!=melody.notes){
                    a =false;
                }
                if (!a){
                    if (notes.get(i).equals(Notes.DO)){
                        if (accidentals.get(i).equals(Accidentals.FLAT)){ //si naturañ
                                if (melody.notes.get(i)==Notes.SI&&melody.accidentals.get(i)==Accidentals.NATURAL){
                                a=true;
                                }
                        }
                        if (accidentals.get(i).equals(Accidentals.SHARP)){//RE Flat
                            if (melody.notes.get(i)==Notes.RE&&melody.accidentals.get(i)==Accidentals.FLAT){
                                a=true;
                            }
                        }
                        if (accidentals.get(i).equals(Accidentals.NATURAL)){ //si Sharp
                            if (melody.notes.get(i)==Notes.SI&&melody.accidentals.get(i)==Accidentals.SHARP){
                                a=true;
                            }
                        }
                    }
                    if (notes.get(i).equals(Notes.RE)){
                        if (accidentals.get(i).equals(Accidentals.FLAT)){//DO sharp
                            if (melody.notes.get(i)==Notes.DO&&melody.accidentals.get(i)==Accidentals.SHARP){
                                a=true;
                            }
                        }
                        if (accidentals.get(i).equals(Accidentals.SHARP)){ //mi flat
                            if (melody.notes.get(i)==Notes.MI&&melody.accidentals.get(i)==Accidentals.FLAT){
                                a=true;
                            }
                        }
                    }
                    if (notes.get(i).equals(Notes.MI)){
                        if (accidentals.get(i).equals(Accidentals.FLAT)){// RE Sharp
                            if (melody.notes.get(i)==Notes.RE&&melody.accidentals.get(i)==Accidentals.SHARP){
                                a=true;
                            }
                        }
                        if (accidentals.get(i).equals(Accidentals.NATURAL)){ //fa flat
                            if (melody.notes.get(i)==Notes.FA&&melody.accidentals.get(i)==Accidentals.FLAT){
                                a=true;
                            }
                        }
                        if (accidentals.get(i).equals(Accidentals.SHARP)){ //fa natural
                            if (melody.notes.get(i)==Notes.FA&&melody.accidentals.get(i)==Accidentals.NATURAL){
                                a=true;
                            }
                        }
                    }
                    if (notes.get(i).equals(Notes.FA)){
                        if (accidentals.get(i).equals(Accidentals.FLAT)){//re sharp
                            if (melody.notes.get(i)==Notes.RE&&melody.accidentals.get(i)==Accidentals.SHARP){
                                a=true;
                            }
                        }
                        if (accidentals.get(i).equals(Accidentals.NATURAL)){// mi sharp
                            if (melody.notes.get(i)==Notes.MI&&melody.accidentals.get(i)==Accidentals.SHARP){
                                a=true;
                            }
                        }
                        if (accidentals.get(i).equals(Accidentals.SHARP)){ //sol flat
                            if (melody.notes.get(i)==Notes.SOL&&melody.accidentals.get(i)==Accidentals.FLAT){
                                a=true;
                            }
                        }
                    }
                    if (notes.get(i).equals(Notes.SOL)){
                        if (accidentals.get(i).equals(Accidentals.FLAT)){//fa sharp
                            if (melody.notes.get(i)==Notes.FA&&melody.accidentals.get(i)==Accidentals.SHARP){
                                a=true;
                            }
                        }
                        if (accidentals.get(i).equals(Accidentals.SHARP)){// la flat
                            if (melody.notes.get(i)==Notes.LA&&melody.accidentals.get(i)==Accidentals.FLAT){
                                a=true;
                            }
                        }
                     }
                    if (notes.get(i).equals(Notes.LA)){
                        if (accidentals.get(i).equals(Accidentals.FLAT)){ //sol sharp
                            if (melody.notes.get(i)==Notes.SOL&&melody.accidentals.get(i)==Accidentals.SHARP){
                                a=true;
                            }
                        }
                        if (accidentals.get(i).equals(Accidentals.SHARP)){//si flat
                            if (melody.notes.get(i)==Notes.SI&&melody.accidentals.get(i)==Accidentals.FLAT){
                                a=true;
                            }
                        }
                    }
                    if (notes.get(i).equals(Notes.SI)){
                        if (accidentals.get(i).equals(Accidentals.FLAT)){// la flat
                            if (melody.notes.get(i)==Notes.LA&&melody.accidentals.get(i)==Accidentals.FLAT){
                                a=true;
                            }
                        }
                        if (accidentals.get(i).equals(Accidentals.NATURAL)){ //do flat
                            if (melody.notes.get(i)==Notes.DO&&melody.accidentals.get(i)==Accidentals.FLAT){
                                a=true;
                            }
                        }
                        if (accidentals.get(i).equals(Accidentals.SHARP)){ //do natural
                            if (melody.notes.get(i)==Notes.DO&&melody.accidentals.get(i)==Accidentals.NATURAL){
                                a=true;
                            }
                        }
                    }
                }
            }
           return a;
        }
    }
// SHARP #, FLAT b,NATURAL
    @Override
    public int hashCode() {
        return Objects.hash(/*notes, accidentals,*/ times);
    }
    /**
     * The string representation of this melody .
     * @return The String representantion of this melody .
     */
    @Override
    public String toString () {
        StringBuilder a= new StringBuilder();
        for (int i=0;i<notes.size();i++) {
            if (i!=0){
                a.append(" ");
            }
            a.append(notes.get(i));
            if (accidentals.get(i)==Accidentals.FLAT){
                a.append("b");
            }
            else if (accidentals.get(i)==Accidentals.SHARP){
                a.append("#");
            }
            a.append("(").append(times.get(i)).append(")");
        }
        return a.toString();
    }
}