INSERT INTO USER (ID, USERNAME, PASSWORD) VALUES (1, 'Harald', '123456');
INSERT INTO USER (ID, USERNAME, PASSWORD) VALUES (2, 'Werner', 'fussball');
INSERT INTO USER (ID, USERNAME, PASSWORD) VALUES (3, 'Friedrich', 'Holsten');

INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (4, 'Kein Titel', 'Beim Anzeigen von geschlossenen Defects wird der Titel nicht mehr angezeigt', '2018-02-19 11:55:00', 1, 'CREATED');
INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (5, 'Loginprobleme', 'User 3 und 4 funktionieren nicht', '2018-02-20 16:45:00', 2, 'REJECTED');
INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (7, 'Datenanzeige', 'Es wird nur ein Teil der darzustellenden Daten übermittelt', '2018-02-20 14:29:00', 2, 'REOPENED');
INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (8, 'Footer fehlt', 'Fußleiste mit Impressum wird nicht angezeigt', '2018-02-22 09:30:00', 3, 'RESOLVED');
INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (9, 'Geomapping fehlerhaft', 'Europakarte wird zur Hälfte abgeschnitten', '2018-02-22 09:30:00', 3, 'CLOSED');
INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (10, 'UI Probleme', 'Benutzeroberfläche flackert unregelmäßig beim scrollen', '2018-02-23 13:00:00', 1, 'IN_PROCESS');

