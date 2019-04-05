package Core;

import Common.ReservedColors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Function;

public class Menu {
    private String title;
    private ArrayList<String> elements;
    private Function<String, Void> callback;

    public Menu(String title, ArrayList<String> elements, Function<String, Void> function) {
        this.title = title;
        this.elements = elements;
        this.callback = function;
    }

    public void show() {
        printElements();
        chooseElement();
    }

    private void printElements() {
        if (!title.isEmpty())
            System.out.println(title);

        for(int i=0; i<elements.size(); i++){

            String color = colorByIndex(i);

            System.out.println(color + (i + 1) + ". " + elements.get(i));
        }
        System.out.println(ReservedColors.ANSI_RESET);
    }

    private void chooseElement(){
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int index = Integer.parseInt(reader.readLine());
            callback.apply(elements.get(index-1));
            reader.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private String colorByIndex(int index) {
        int size = ReservedColors.list.size();
        return ReservedColors.list.get(index % size);
    }
}