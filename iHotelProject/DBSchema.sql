
CREATE TABLE booking
  (
    bookingid NUMBER (15) NOT NULL ,
    userid    NUMBER (15) NOT NULL ,
    roomid    NUMBER (15) NOT NULL ,
    checkin   TIMESTAMP NOT NULL ,
    checkout  TIMESTAMP NOT NULL ,
    details   VARCHAR2 (200 BYTE) NOT NULL
  ) ;
ALTER TABLE booking ADD CONSTRAINT booking_PK PRIMARY KEY ( bookingid ) ;



CREATE TABLE room
  (
    roomid    NUMBER (15) NOT NULL ,
    roomno    NUMBER (15) NOT NULL ,
    floorno   NUMBER (5) NOT NULL ,
    room_type VARCHAR2 (1 CHAR) NOT NULL ,
    price FLOAT (15) NOT NULL ,
    bathroom       CHAR (1) NOT NULL ,
    room_available CHAR
    --  WARNING: CHAR size not specified
    NOT NULL ,
    notes VARCHAR2 (200 BYTE) NOT NULL
  ) ;

ALTER TABLE room ADD CONSTRAINT room_PK PRIMARY KEY ( roomid ) ; ALTER ALTER TABLE room 
add Constraint room_bathroom _ck CHECK (room_bathroom ='Y' OR room_bathroom ='N');

CREATE TABLE "user"
  (
    userid      NUMBER (15) NOT NULL ,
    email       VARCHAR2 (50 BYTE) NOT NULL ,
    password    VARCHAR2 (50 BYTE) NOT NULL ,
    type        INTEGER NOT NULL ,
    phonenumber VARCHAR2 (15 BYTE) NOT NULL ,
    fname       VARCHAR2 (20 BYTE) NOT NULL ,
    lname       VARCHAR2 (20 BYTE) NOT NULL
  ) ;
ALTER TABLE "user" ADD CONSTRAINT user_PK PRIMARY KEY ( userid ) ;


ALTER TABLE booking ADD CONSTRAINT booking_room_FK FOREIGN KEY ( roomid ) REFERENCES room ( roomid ) ;

ALTER TABLE booking ADD CONSTRAINT booking_user_FK FOREIGN KEY ( userid ) REFERENCES "user" ( userid ) ;



