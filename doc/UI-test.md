A UI teszteléshez utánanéztünk a felsorolt 3 opciónak, majd a projekt fajtája miatt a Tosca alkalmazást választottuk. <br><br>
Ebben készítettünk egy új tosca projektet. A játékot úgy kellett tesztelni, hogy bescanneltünk különböző képernyőket, amiket tesztelni szerettünk volna, a tosca beépített tooljával. (Ezek lettek a modulok)<br><br>
<img src="./img/ui-test/modules.png" height="300"><br>
Ezután a tesztesetekhez hozzáadtuk azokat, amiket hasznosnak gondoltunk, majd megadtunk hozzá értékelés kritériumokat, illetve akciókat. Például, hogy amikor az End Turn-re kattintás után valóban a következő játékos következik-e a kiírás alapján. <br><br>
<p align=center>
<img src="./img/ui-test/test.png" height="350"><br></p>
Készítettünk több ilyen tesztesetet, úgy, hogy folyamatos legyen, tehát az egymás után következő tesztesetek valóban egymás után következhessenek a játékban.<br><br>
Ezeket a teszteseteket futtattuk az Execution fülön. Ekkor magától letesztelte a UI működését a tesztesetek szerint az alkalmazás, majd kiadta az eredményt összesítve, és tesztesetenként is.<br><br>
A tesztelést megnehezítette, hogy rengeteg funkció a lenyíló füleknél ellenőrizhető, ezt pedig a Tosca nem megfelelően scannelte be. De a tesztelhető funkciók működtek:<br>
<ul>
<li>A játék megfelelő indítása (játékos megadása, és Start Game gomb a megfelelő mennyiségű játkossal indít játékot.)</li>
<li>A játék indításakor megfelelőek az adatok: 1. kör, 1. játékos, 0 aminosav, 0 nukleotid.</li>
<li>A játékos lépése: A játékos kattintásra a megfelelő mezőre kerül. (Ezt a gomb Input mezőre váltásával csináltuk)</li>
<li>A játékos körének befejezése: a játékos az End Turnre kattint, ekkor a következő játékos következik.</li>
<li>A játékos anyagfelvétele: mikor a játékos mezőről anyagot vesz fel, az a mezőről eltűnik, megjelenik a játékos inventoryjában.</li>
<li>stb.</li>
<img src="./img/ui-test/result.png" height="350"><br>
</ul>