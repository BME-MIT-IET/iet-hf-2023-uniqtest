<p align=center style="font-size: 20px">Manuális tesztek dokumentálása<br
<img src="./img/manual-test/fullscreen.png" height="350"><br></p>

1.	Teszteset: Lépés
A megfelelő neighbourfield gombra kattintva a játékos valóban a megfelelő mezőre lép át.<br>
<img src="./img/manual-test/shelter.png" width="600"><br>
2.	Teszteset: Köpeny felvétele
A köpeny ikonra kattintva megjelent az Equipments fülben a köpeny szöveg és az Effects fül alatt is látszik, hogy a köpeny hatása rákerült a játékosra.<br>
<img src="./img/manual-test/capeon.png" width="600"><br>
3.	Teszteset: Köpeny eldobása
Az Equipments fülben a Köpeny szövegre kattintva a játékos eldobja a köpenyt és az újra megjelenik a mezőn.<br>
4.	Teszteset: Játékos váltás
Az End Turn gombra kattintva játékost váltottunk. A jobb oldalon a Player: 1 helyett Player: 2 jelent meg.<br>
<img src="./img/manual-test/endturn.png" width="600"><br>
5.	Teszteset: Játékos medvevírussal fertőződött meg
A neighbourfield gombra kattintva a játékos egy másik mezőre lépett, ami valójában egy csapda volt. A játékos ikonja ilyenkor átváltott medve ikonra.<br>
<img src="./img/manual-test/medvevirus.png" width="600"><br>
6.	Teszteset: Help button
A Help Button megnyomásakor a játékról egy érthető, egyértelmű használati utasítást kapunk, viszont az <b>ékezetek nem jól vannak kezelve.</b><br>
<img src="./img/manual-test/help.png" width="600"><br>
7.	Teszteset: Raktár mezőre lépés
A raktárra lépéskor (neighbourfield gombra kattintva) látszik, hogy van Amino és Nukleotid a mezőn és ezek mellett a mennyiség is látszik. <br>
<img src="./img/manual-test/storage.png" width="600"><br>
8.	Teszteset: Anyag felvétel
Az anyag ikonra kattintva, a mező anyaga 10 egységgel csökkent és a felhasználónál 10 egységgel növekedett. Az anyagra újra rákattintva, nem történik anyag felvétel, mert a felhasználó elérte a maximális felszedhető anyag számot.<br>
<img src="./img/manual-test/anyagfelvet.png" width="600"><br>
9.	Teszteset: Genetikai kód megtanulása
A neighbourfield gombra kattintva egy laborra érkeztünk, majd a genetikai kódra kattintva a felhasználó megtanulta a kódot, ami a gencode fülben is látszik.
<img src="./img/manual-test/labgen.png" width="600"><br>
10.	Teszteset: Medve lépés
A 2. neighbourfield gombra kattintva a medve nem az általa kiválasztott mezőre került. A Storage mezőre próbált rálépni, de nem oda került. Ez helyes működést eredményez, ugyanis a medvének random kell lépnie.
Felfedeztük a következő hibákat:<br><b>
•	A medve genetikai kódokat képes megtanulni<br>
•	Ugyanazt a genetikai kódot megtanulva, a genetikai kód többször kerül felsorolásra a listában. Mivel a listában maximum 4 genetikai kód lehet, ezért ez probléma.</b>

11.	Teszteset: Medve elpusztítja az anyagot
Ha a medve véletlenül a raktár mezőre lép, akkor az ott lévő aminok és nukleotidok száma lenullázódik. Ez helyes működés, ugyanis a medvének el kell pusztítania ezeket, ha ilyen mezőre lép.

12.	Teszteset: Dupla lépés
A játékos egy lépés után megpróbált még egyszer lépni, de ekkor valójában nem történt lépés. Ez helyes működést eredményez, viszont jó lenne erről tájékoztatni a felhasználót, valamilyen formában, hogy egyszerre csak egyet lépet és már nem léphet többször.

13.	Teszteset: Nem lebénult játékostól lopás megkísérlése
A lopás ebben az esetben valóban nem sikerült. Ez helyes működés, csak lebénult játékostól lehet tárgyakat lopni.
<br>
<img src="./img/manual-test/stealfail.png" width="600"><br>
14.	Teszteset: Anyag felvétele táska birtokában
A játékos megpróbált táska birtokában anyagot felvenni, ez sikerült neki. A maximális 10 egység helyett, jelenleg 15 egységnyi anyag van birtokában.
<br>
<img src="./img/manual-test/storage.png" width="600"><br>
15.	Teszteset: Ágens készítése
A játékos megpróbált ágens készíteni, ehhez a saját birtokában levő GenCode-ra kellett kattintania, az ágensek fül alatt megjelent a Dance ágens szöveg és az anyagszáma is lecsökkent.
<br>
<img src="./img/manual-test/agentcreation.png" width="600"><br>
16.	Teszteset: Ágens kenés
A játékos készített egy dance ágenst. Az ágens fülön kiválasztottuk az ágenst, amit használni akartunk, majd a játékost, akire az ágenst kenni szeretnénk, ezek után az ágens eltűnt az ágens fül listából. A soron következő megkent játékosnak véletlenszerűen kell lépnie az ágens hatása miatt, <b>viszont az általa választott mezőre lépett és az Effects fül alatt sem látszik az ágens hatása, tehát a kenés valójában nem sikerült.</b>
<br>
<img src="./img/manual-test/useagent.png" width="600"><br>
17.	Teszteset: Játék elmentése
A Save gomb megnyomásakor a konzolon megjelent a „Saved” szöveg és létrejött egy save_olvashato.txt és egy save.txt fájl. Azt tapasztaltuk, hogy a fájlban levő adatok megfelelnek a játék állása alapján, <b>viszont a fájlokat célszerűbb lenne másképpen elnevezni, és ne mindig a korábbi fájlt írja felül.</b>
<br>
<img src="./img/manual-test/savedgame.png" width="600"><br>
18.	Teszteset: Játék betöltése
A Load from file gombra kattintva és a save.txt fájlt kiválasztva a játék sikeresen betöltésre került és ugyanazt az állapotot kaptuk, ahol korábban abbahagytuk, tehát a betöltés sikeres volt.
