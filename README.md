# Navigation-Sample
A simple app to show how to pass arguments between screens using the Navigation Library from Jetpack Compose.

This app consists of 2 screens, Screen One and Screen Two. Screen One contains an input field and a button; when the field is populated the button becomes active and, tapping it, navigates to Screen Two.

Screen Two simply displays a text populated with the content from the input field from the first screen, that is passed as a route argument when navigating to the second screen and retrieved in the viewmodel for the second screen.

