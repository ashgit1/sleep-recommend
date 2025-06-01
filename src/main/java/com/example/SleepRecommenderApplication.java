package com.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import java.time.LocalDate;
import java.time.Period;

@Route("")
public class SleepRecommenderApplication extends VerticalLayout {
    private TextField nameField;
    private DatePicker dobPicker;
    private Button calculateButton;
    private TextField ageField;
    private TextField sleepRecommendationField;

    public SleepRecommenderApplication() {
        // Set layout properties
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setSizeFull();
        setPadding(true);
        setSpacing(true);
        
        // Create heading
        H1 heading = new H1("Sleep Duration Calculator");
        heading.getStyle().set("margin-bottom", "20px");
        
        // Create UI components
        nameField = new TextField("Your Name");
        dobPicker = new DatePicker("Date of Birth");
        calculateButton = new Button("Calculate");
        ageField = new TextField("Age");
        sleepRecommendationField = new TextField("Recommended Sleep Duration");
        
        // Add heading to layout
        add(heading);

        // Configure components
        ageField.setReadOnly(true);
        sleepRecommendationField.setReadOnly(true);
        dobPicker.setMin(LocalDate.of(1900, 1, 1));
        dobPicker.setMax(LocalDate.now());
        
        // Style components
        nameField.setWidth("300px");
        dobPicker.setWidth("300px");
        calculateButton.setWidth("300px");
        ageField.setWidth("300px");
        sleepRecommendationField.setWidth("300px");

        // Add components to layout
        add(nameField, dobPicker, calculateButton, ageField, sleepRecommendationField);

        // Add button click listener
        calculateButton.addClickListener(e -> calculateAgeAndSleep());
    }

    private void calculateAgeAndSleep() {
        try {
            // Get input values
            String name = nameField.getValue();
            LocalDate dob = dobPicker.getValue();

            if (name.isEmpty() || dob == null) {
                Notification.show("Please enter your name and date of birth").setPosition(Notification.Position.TOP_CENTER);
                return;
            }

            // Calculate age
            LocalDate today = LocalDate.now();
            Period period = Period.between(dob, today);
            int age = period.getYears();
            ageField.setValue("" + age + " years");

            // Calculate recommended sleep duration based on age
            String recommendation = getSleepRecommendation(age);
            sleepRecommendationField.setValue(recommendation);

            // Show success notification
            Notification.show("Results calculated successfully!").setPosition(Notification.Position.TOP_CENTER);
        } catch (Exception ex) {
            Notification.show("An error occurred: " + ex.getMessage()).setPosition(Notification.Position.TOP_CENTER);
        }
    }

    private String getSleepRecommendation(int age) {
        if (age < 1) {
            return "Newborns (0-3 months): 14-17 hours";
        } else if (age < 2) {
            return "Infants (4-11 months): 12-15 hours";
        } else if (age < 3) {
            return "Toddlers (1-2 years): 11-14 hours";
        } else if (age < 6) {
            return "Preschoolers (3-5 years): 10-13 hours";
        } else if (age < 14) {
            return "School-age children (6-13 years): 9-11 hours";
        } else if (age < 18) {
            return "Teenagers (14-17 years): 8-10 hours";
        } else if (age < 65) {
            return "Adults (18-64 years): 7-9 hours";
        } else {
            return "Older adults (65+ years): 7-8 hours";
        }
    }
}
