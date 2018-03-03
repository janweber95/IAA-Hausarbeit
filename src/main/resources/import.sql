INSERT INTO USER (ID, USERNAME, PASSWORD, EMAIL, FULL_NAME) VALUES (1000, 'Harald', '123456', 'h.baecker@outlook.com', 'Harald Bäcker');
INSERT INTO USER (ID, USERNAME, PASSWORD, EMAIL, FULL_NAME) VALUES (1001, 'Werner', 'fussball', 'werner64@web.de', 'Werner Müller');
INSERT INTO USER (ID, USERNAME, PASSWORD, EMAIL, FULL_NAME) VALUES (1002, 'Friedrich', 'Holsten', 'friedrich.otto@gmx.de', 'Friedrich Otto');

INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (1, 'Kein Titel', 'Beim Anzeigen von geschlossenen Defects wird der Titel nicht mehr angezeigt', '2018-02-19 11:55:00', 1000, 'CREATED');
INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (2, 'Loginprobleme', 'User 3 und 4 funktionieren nicht', '2018-02-20 16:45:00', 1001, 'REJECTED');
INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (3, 'Datenanzeige', 'Es wird nur ein Teil der darzustellenden Daten übermittelt', '2018-02-20 14:29:00', 1001, 'REOPENED');
INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (4, 'Footer fehlt', 'Fußleiste mit Impressum wird nicht angezeigt', '2018-02-22 09:30:00', 1002, 'RESOLVED');
INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (5, 'Geomapping fehlerhaft', 'Europakarte wird zur Hälfte abgeschnitten', '2018-02-22 09:30:00', 1002, 'CLOSED');
INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (6, 'UI Probleme', 'Benutzeroberfläche flackert unregelmäßig beim scrollen', '2018-02-23 13:00:00', 1000, 'CLOSED');

INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (6, 1001, '', 'IN_PROCESS', 'CREATED', '2018-02-20 10:30:00');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (6, 1001, 'Kann ich nicht reproduzieren.', 'REJECTED', 'IN_PROCESS', '2018-02-20 10:50:00');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (6, 1000, 'Ich verwende Internet Explorer 8. Bitte nochmal damit testen!', 'REOPENED', 'REJECTED', '2018-02-20 14:30:00');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (6, 1001, '', 'IN_PROCESS', 'REOPENED', '2018-02-21 09:30:00');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (6, 1001, 'Das Problem war eine JavaScript-Bibliothek, die nicht mit IE8 kompatibel ist. Für IE8 und vorherige Versionen wird eine gesonderte Bibliothek eingebunden.', 'RESOLVED', 'IN_PROCESS', '2018-02-21 10:30:00');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (6, 1000, 'Das Scrollen sieht flüssig aus.', 'CLOSED', 'RESOLVED', '2018-02-21 11:00:00');

