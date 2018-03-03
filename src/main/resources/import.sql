INSERT INTO USER (ID, USERNAME, PASSWORD, EMAIL, FULL_NAME) VALUES (1000, 'Harald', '123456', 'h.baecker@outlook.com', 'Harald Bäcker');
INSERT INTO USER (ID, USERNAME, PASSWORD, EMAIL, FULL_NAME) VALUES (1001, 'Werner', 'fussball', 'werner64@web.de', 'Werner Müller');
INSERT INTO USER (ID, USERNAME, PASSWORD, EMAIL, FULL_NAME) VALUES (1002, 'Friedrich', 'Holsten', 'friedrich.otto@gmx.de', 'Friedrich Otto');

INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (1, 'Kein Titel', 'Beim Anzeigen von geschlossenen Defects wird der Titel nicht mehr angezeigt', '2018-02-19 11:55:00', 1000, 'CREATED');
INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (2, 'Loginprobleme', 'User 3 und 4 funktionieren nicht', '2018-02-20 16:45:00', 1001, 'REJECTED');
INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (3, 'Datenanzeige', 'Es wird nur ein Teil der darzustellenden Daten übermittelt', '2018-02-20 17:29:00', 1001, 'REOPENED');
INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (4, 'Footer fehlt', 'Fußleiste mit Impressum wird nicht angezeigt', '2018-02-22 09:30:00', 1002, 'RESOLVED');
INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (5, 'Geomapping fehlerhaft', 'Europakarte wird zur Hälfte abgeschnitten', '2018-02-22 09:30:00', 1002, 'CLOSED');
INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (6, 'UI Probleme', 'Benutzeroberfläche flackert unregelmäßig beim scrollen', '2018-02-23 13:00:00', 1000, 'CLOSED');
INSERT INTO DEFECT (ID, TITLE, DESCRIPTION, CREATION_DATE, CREATOR_ID, STATUS) VALUES (7, 'Navigierungsprobleme', 'Navigierungsprobleme auf der Übersichtsseite', '2018-02-27 16:30:00', 1000, 'IN_PROCESS');

INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (2, 1000, '', 'IN_PROCESS', 'CREATED', '2018-02-20 17:30:00');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (2, 1000, 'Bei mir funktioniert der Login mit beiden Usern.', 'REJECTED', 'IN_PROCESS', '2018-02-20 17:34:48');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (2, 1001, 'Wenn ich mich mit dem Nutzernamen "Testuser3" und dem Passwort "Testpasswort" auf dem UAT System versuche einloggen, bekomme ich die Meldung, dass der Nutzer gesperrt ist. Gleiches gilt für Testuser4.', 'REOPENED', 'REJECTED', '2018-02-21 08:59:11');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (2, 1000, '', 'IN_PROCESS', 'REOPENED', '2018-02-21 09:47:12');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (2, 1000, 'Der Login mit den von dir genannten Daten auf dem UAT klappt bei mir alles. Bitte den Defect schließen.', 'REJECTED', 'IN_PROCESS', '2018-02-21 10:03:49');

INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (3, 1000, '', 'IN_PROCESS', 'CREATED', '2018-02-21 09:15:37');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (3, 1000, 'Welche Daten fehlen? Kann ich nicht reproduzieren, da ich zu wenig Informationen habe.', 'REJECTED', 'IN_PROCESS', '2018-02-21 09:22:13');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (3, 1001, 'Ich habe dir ein Dokument per Mail geschickt, das sollte dabei helfen, die Daten zu validieren.', 'REOPENED', 'REJECTED', '2018-02-21 12:48:20');


INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (4, 1001, 'Problem gab es schonmal, sollte ich schnell beheben.', 'IN_PROCESS', 'CREATED', '2018-02-22 09:47:00');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (4, 1001, 'Friedrich bitte teste nochmal.', 'RESOLVED', 'IN_PROCESS', '2018-02-22 10:05:00');

INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (5, 1000, 'Ich guck mal wo der Fehler liegt, Friedrich.', 'IN_PROCESS', 'CREATED', '2018-02-22 10:30:00');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (5, 1000, 'ESRI Karte wird nicht richtig übermittelt, ich habe etwas an der Schnittstelle angepasst, guck bitte nochmal, ob sie jetzt richtig übermittelt wird.', 'RESOLVED', 'IN_PROCESS', '2018-02-23 12:37:00');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (5, 1002, 'Karte wird jetzt wie erwartet komplett angezeigt!', 'CLOSED', 'RESOLVED', '2018-02-24 14:35:00');

INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (6, 1001, '', 'IN_PROCESS', 'CREATED', '2018-02-24 10:30:00');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (6, 1001, 'Kann ich nicht reproduzieren.', 'REJECTED', 'IN_PROCESS', '2018-02-24 10:50:00');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (6, 1000, 'Ich verwende Internet Explorer 8. Bitte nochmal damit testen!', 'REOPENED', 'REJECTED', '2018-02-24 14:30:00');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (6, 1001, '', 'IN_PROCESS', 'REOPENED', '2018-02-25 09:30:00');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (6, 1001, 'Das Problem war eine JavaScript-Bibliothek, die nicht mit IE8 kompatibel ist. Für IE8 und vorherige Versionen wird eine gesonderte Bibliothek eingebunden.', 'RESOLVED', 'IN_PROCESS', '2018-02-25 10:30:00');
INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (6, 1000, 'Das Scrollen sieht flüssig aus.', 'CLOSED', 'RESOLVED', '2018-02-25 11:00:00');

INSERT INTO DEFECT_CHANGES (DEFECT_ID, EDITOR_ID, COMMENT, NEW_STATUS, PREVIOUS_STATUS, CHANGE_TIME) VALUES (7, 1002, 'Schauen wir uns mal an!', 'IN_PROCESS', 'CREATED', '2018-02-28 12:32:00');
