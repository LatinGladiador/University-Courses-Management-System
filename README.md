# University-Courses-Management-System

## Problem Description

An IT university desires to develop a course management system. Courses have fixed capacities and students can only be enrolled in a limited number of courses if their capacity allows for it.
![image](https://github.com/LatinGladiador/University-Courses-Management-System/assets/118859294/763e373f-bc7a-4b3b-830e-e0d3ab30c10d)
### Initial Instances

#### Courses to add:

| courseId | courseName           | courseLevel |
|----------|----------------------|-------------|
| 1        | java_beginner        | bachelor    |
| 2        | java_intermediate    | bachelor    |
| 3        | python_basics        | bachelor    |
| 4        | algorithms           | master      |
| 5        | advanced_programming | master      |
| 6        | mathematical_analysis| master      |
| 7        | computer_vision      | master      |

#### Students to add:

| memberId | memberName | enrolledCourses              |
|----------|------------|------------------------------|
| 1        | Alice      | java_beginner, java_intermediate, python_basics |
| 2        | Bob        | java_beginner, algorithms    |
| 3        | Alex       | advanced_programming         |

#### Professors to add:

| memberId | memberName | enrolledCourses              |
|----------|------------|------------------------------|
| 4        | Ali        | java_beginner, java_intermediate |
| 5        | Ahmed      | python_basics, advanced_programming |
| 6        | Andrey     | mathematical_analysis        |

### Methods

- **fillInitialData()**: load the provided instances with the arguments from the abovementioned tables.
- **teach(Course)**: assign the professor to teach a course if not already teaching it and has not reached his/her course load limit.
- **exempt(Course)**: exempt the professor from teaching a course if he/she is currently teaching it.
- **enroll(Course)**: enroll the student in a course if the student is not already enrolled, did not reach the maximum number of enrollments, and if the course is not full of students.
- **drop(Course)**: drop the student from a course if he/she is currently enrolled.
- **isFull()**: check if the course has reached its enrollment capacity.

### Rules

- Each course has a capacity of 3 students.
- A student can't be enrolled in the same course more than once.
- A student cannot be enrolled in more than 3 courses.
- A student cannot be enrolled in a course that is full (already 3 students enrolled this course).
- Professor cannot be assigned to a course he/she is already teaching.
- Professor cannot be assigned to teach more than 2 courses.
- Professor cannot be exempted from the course, if not teaching it.

### Input Format

The inputs are represented by standard input. The program should read the input line by line. It checks the correctness of the input line, if it is correct, it waits for the next line, otherwise it prints an error message and terminates the program. Whenever the empty line is met, the program should stop its execution. There can be multiple commands.

#### Command	Input format

- Add course: `course courseName courseLevel`
- Add student: `student memberName`
- Add professor: `professor memberName`
- Enroll to course: `enroll memberId courseId`
- Drop from course: `drop memberId courseId`
- Assign to course: `teach memberId courseId`
- Exempt from course: `exempt memberId courseId`

### Output Format

The outputs are represented by standard output. Each output line should be generated for each read and performed input command.

#### Message for each command:

| Command | Message                                        |
|---------|------------------------------------------------|
| course  | Added successfully                             |
| student | Added successfully                             |
| professor | Added successfully                           |
| enroll  | Enrolled successfully                          |
| drop    | Dropped successfully                           |
| exempt  | Professor is exempted                          |
| teach   | Professor is successfully assigned to teach this course |

#### Error Messages

- Course exists
- Student is already enrolled in this course
- Maximum enrollment is reached for the student
- Course is full
- Student is not enrolled in this course
- Professor's load is complete
- Professor is already teaching this course
- Professor is not teaching this course
- Wrong inputs

### Examples

#### Input
course
Java_advanced
master

#### Output
Added successfully

#### Input
enroll
1
1

#### Output
Student is already enrolled in this course

#### Input
student
siba
enroll
7
5
enroll
7
6
enroll
7
4
enroll
7
2

#### Output
Added successfully
Enrolled successfully
Enrolled successfully
Enrolled successfully
Maximum enrollment is reached for the student


### Note

Note that the use of @SuppressWarnings for Checkstyle plugin will be considered as a cheating case.







