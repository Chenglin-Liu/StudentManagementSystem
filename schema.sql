USE student_management_system;

-- Student
CREATE TABLE IF NOT EXISTS Student(
    id           INT,
    name         VARCHAR(30) NOT NULL,
    gender       VARCHAR(10) NOT NULL,
    password   VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

-- student stream(Muti-variable attribute)
CREATE TABLE IF NOT EXISTS Student_stream(
    id         INT,
    stream     VARCHAR(30),
    PRIMARY KEY (id, stream),
    FOREIGN KEY (id) REFERENCES Student(id)
);

-- Teacher
CREATE TABLE IF NOT EXISTS Teacher(
    id         INT,
    name       VARCHAR(30) NOT NULL,
    title      VARCHAR(20) NOT NULL,
    email      VARCHAR(20),
    password   VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

-- Courese
CREATE TABLE IF NOT EXISTS Course(
    code             VARCHAR(10),
    name             VARCHAR(30) NOT NULL,
    maxCapacity      INT,
    briefDescription VARCHAR(100),
    teacherID        INT,
    term             VARCHAR(10),
    PRIMARY KEY(code, term),
    FOREIGN KEY (teacherID) REFERENCES Teacher(id)
);

-- ENROL
CREATE TABLE IF NOT EXISTS ENROL(
    studentID INT,
    courseCode  VARCHAR(10),
    term      VARCHAR(10) NOT NULL,
    mark      INT DEFAULT NULL,
    PRIMARY KEY(studentID, courseCode, term),
    FOREIGN KEY(studentID) REFERENCES Student(id),
    FOREIGN KEY(courseCode) REFERENCES Course(code)
);


