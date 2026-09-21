# Lab 03 — Jetpack Compose UI, Modifiers & Material 3

This lab focuses on building reusable UI components using Jetpack Compose and understanding how modifiers, Material 3 colors, typography, previews, and screen layouts work together in an Android application.

## Project Structure

- `CSC402_Lab3/` — Android Studio project
- `Screenshots/` — Screenshots of completed tasks
- `README.md` — Lab documentation

## Completed Tasks

### Task 1 — Modifier-Accepting Composable
- Created a `Student` data class
- Created a reusable `StudentCard` composable
- Added a `Modifier` parameter
- Added a preview for the component

### Task 2 — Profile Card Layout
- Rebuilt the student profile card using:
  - `Card`
  - `Column`
  - `Row`
  - `Text`
  - `HorizontalDivider`
- Displayed student name, program, GPA, email, and city

### Task 3 — Avatar and Status Badge
- Added a circular avatar
- Added a status indicator badge
- Used `Box`, `CircleShape`, and layout modifiers

### Task 4 — Modifier Order Puzzle
- Compared different modifier orders
- Observed the effect of:
  - `background`
  - `padding`
  - `clip`
  - `clickable`
- Demonstrated how modifier order affects layout and touch areas

### Task 5 — Material Color Roles
- Replaced hard-coded colors with `MaterialTheme.colorScheme`
- Used Material 3 color roles such as:
  - `primary`
  - `onPrimary`
  - `onSurface`
  - `onSurfaceVariant`
  - `tertiary`

### Task 6 — Material Typography
- Replaced manual font sizes with `MaterialTheme.typography`
- Used typography roles including:
  - `titleLarge`
  - `titleMedium`
  - `bodyMedium`

### Task 7 — Light and Dark Mode Preview
- Added previews for both Light and Dark themes
- Verified that the UI adapts correctly using Material Theme colors

### Task 8 — Scaffold and TopAppBar
- Added a `Scaffold`
- Added a `TopAppBar`
- Added a `FloatingActionButton`
- Demonstrated incorrect and correct usage of `innerPadding`

### Task 10 — Student List with LazyColumn
- Displayed multiple students using `LazyColumn`
- Reused the existing `StudentCard`
- Added:
  - `contentPadding`
  - `Arrangement.spacedBy`
  - Header with title and student count

## Key Concepts Practiced

- Jetpack Compose
- Reusable Composables
- Modifier chaining
- Material 3
- Color schemes
- Typography
- Light/Dark themes
- Scaffold
- TopAppBar
- FloatingActionButton
- LazyColumn
- Compose Preview

## Screenshots

Screenshots for the completed tasks are available in the `Screenshots` folder.

## Notes

Task 9 was not included in the final implementation.
