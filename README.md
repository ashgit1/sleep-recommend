# Sleep Recommender Application

This is a Vaadin-based web application that helps users calculate their age and get personalized sleep recommendations based on their age.

## Features

- Enter your name and date of birth
- Automatically calculates your age
- Provides age-appropriate sleep recommendations
- User-friendly interface with validation

## Requirements

- Java 17 or higher
- Maven

## Running the Application

1. Navigate to the project directory:
   ```bash
   cd vaadin-sleep-recommend
   ```

2. Build and run the application:
   ```bash
   mvn spring-boot:run
   ```

3. Open your web browser and navigate to:
   ```
   http://localhost:8080
   ```

## Sleep Recommendations

The application provides age-specific sleep recommendations based on medical guidelines:
- Newborns (0-3 months): 14-17 hours
- Infants (4-11 months): 12-15 hours
- Toddlers (1-2 years): 11-14 hours
- Preschoolers (3-5 years): 10-13 hours
- School-age children (6-13 years): 9-11 hours
- Teenagers (14-17 years): 8-10 hours
- Adults (18-64 years): 7-9 hours
- Older adults (65+ years): 7-8 hours
# sleep-recommend
