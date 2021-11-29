package com.sivaNavaneeth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Notes {

    private String remainder;
    private ArrayList<Notes> notesname;

    Scanner scanner =new Scanner(System.in);

    public Notes(String remainder) {
        this.remainder = remainder;
        this.notesname=new ArrayList<Notes>();
    }
    public String getRemainder() {
        return remainder;
    }
    public static Notes create(String note){
        return new Notes(note);
    }
    public boolean createNotes (Notes newnotes){
        if(findNotes(newnotes.getRemainder())>=0) {
            System.out.println("Notes already exists");
            return false;
        }
        notesname.add(newnotes);
        return true;
    }
    public boolean editNotes(Notes oldName,Notes newName){
        if(findnotes(oldName)<0) {
            System.out.println(oldName.getRemainder() + " was n't found");
            return false;
        }
        this.notesname.set(findnotes(oldName),newName);
        System.out.println(oldName.getRemainder()+" is replace with "+newName.getRemainder());
        return true;
    }
    public boolean removeNotes(Notes notes){
        if(findnotes(notes)<0){
            System.out.println(notes.getRemainder()+" was not found");
            return false;
        }
        this.notesname.remove(findnotes(notes));
        System.out.println(notes.getRemainder()+" was deleted");
        return true;
    }

    public Notes viewNotes(String notes){
        if(findNotes(notes)>=0){
            return this.notesname.get(findNotes(notes));
        }
        return null;
    }
    private int findnotes(Notes notes){
        return this.notesname.indexOf(notes);
    }
    private int findNotes(String Notes){
        for(int i=0;i<notesname.size();i++){
            if(this.notesname.get(i).getRemainder().equals(Notes)){
                return i;
            }
        }
        return -1;
    }
    public void printList(){
        System.out.println("Notes List: ");
        for(int i=0;i<notesname.size();i++){
            System.out.println(this.notesname.get(i).getRemainder());
        }
    }
}

