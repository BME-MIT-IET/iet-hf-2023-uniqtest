# 🔎 Unit tesztelés dokumentáció

A unit teszteléssel a komponenseket elkülönítve, izolált környezetben teszteltük az alkalmazást. Az egyes egységek (pl. osztályok, metódusok) működését külön-külön vizsgáltuk meg, hogy megbizonyosodjunk a helyes működésükről.

# Tesztesetek


## AnointTests

Az AnointTests osztály a Game, Field és Virologist objektumok tesztelését végzi a felkenés funkcionalitásra vonatkozóan.

A tesztek segítségével vizsgáljuk a kenés helyes működését és viselkedését különböző körülmények között.

### __Tesztesetek:__

1️⃣ __TakeAnointTest__

Ez a teszt ellenőrzi, hogy a virológus helyesen alkalmazza-e a kenést.

A teszt lépései:

1. Beállítjuk a virológus kenés viselkedését a "TakeAnoint" objektummal.
2. Létrehozunk egy új virológus objektumot (tempVir), egy mezőt (field) és egy dancerAgent.
3. A kenés műveletet végrehajtjuk a virológuson. 
4. Ellenőrizzük, hogy a virológus hatásai (effects) tartalmazzák-e a dancerAgent-et.


✅ A teszt sikeresnek tekinthető, ha a dancerAgent szerepel a virológus hatásai között.


2️⃣ __BlockAnointTest__:

Ez a teszt ellenőrzi, hogy a virológus helyesen alkalmazza a kenés elháritását.

A teszt lépései:

1. Beállítjuk a virológus kenés viselkedését a "BlockAnoint" objektummal.
2. Létrehozunk egy új virológus objektumot (tempVir), egy mezőt (field) és egy dancerAgent.
3. Az kenést végrehajtjuk a virológuson.
4. Ellenőrizzük, hogy a virológus hatásai  nem tartalmazzák a dancerAgent-et.

✅ A teszt sikeresnek tekinthető, ha a dancerAgent nem szerepel a virológus hatásai között.

3️⃣ __ReturnAnointTest__:

Ez a teszt ellenőrzi, hogy a virológus helyesen alkalmazza a kenés visszadobása viselkedést.

A teszt lépései:

1. Beállítjuk a virológus kenés viselkedését a "ReturnAnoint" objektummal és egy kesztyűt is adunk neki.
2. Létrehozunk egy új virológust, egy mezőt (field) és egy dancerAgentet.
3. Az kenés műveletet végrehajtjuk a virológuson.
4. Ellenőrizzük, hogy a virológus nem tartalmazza a dancerAgentet, míg a tempVir igen.

✅ A teszt sikeresnek tekinthető, ha a dancerAgent nem szerepel a virológus effektjei között, de szerepel a tempVir hatásai között.

4️⃣ __MightBlockAnointTest__

Ez a teszt ellenőrzi, hogy a virológus helyesen alkalmazza-e a "MightBlockAnoint" viselkedést különböző helyzetekben.

A teszt lépései:

1. Létrehozunk egy "MightBlockAnoint" objektumot.
2. Beállítjuk a "MightBlockAnoint" objektum "det" attribútumát "on" értékre.
3. Beállítjuk a virológus kenés viselkedését a "MightBlockAnoint" objektummal.
4. Létrehozunk egy új virológus objektumot (tempVir), egy mezőt (field) és egy dancerAgent-et.
5. Ellenőrizzük, hogy a virológus hatásai nem tartalmazzák a dancerAgentet.
6. Beállítjuk a "MightBlockAnoint" objektum "det" attribútumát "off" értékre.
7. A kenés műveletet végrehajtjuk a tempVir és dancerAgent objektumokkal a virológuson.
8. Ellenőrizzük, hogy a virológus hatásai (effects) tartalmazzák-e a dancerAgentet.


✅ A teszt sikeresnek tekinthető, ha a virológus hatásai nem tartalmazza a dancerAgentet a "det" attribútum "on" esetén, de tartalmazza a "det" attribútum "off" esetén.

5️⃣ __AnointExpiresTest__
Ez a teszt ellenőrzi, hogy az kenés lejárását helyesen kezeli-e a virológus.

A teszt lépései:

1. Beállítjuk a virológus kenés viselkedését a "TakeAnoint" objektummal.
2. Létrehozunk egy új virológus objektumot (tempVir), egy mezőt (field) és egy dancerAgent-et.
3. A kenést végrehajtjuk a virológuson.
4. Háromszor meghívjuk a játék időzítőjének (timer) Tick metódusát.
5. Ellenőrizzük, hogy a virológus hatásai nem tartalmazzák a dancerAgentet.

✅ A teszt sikeresnek tekinthető, ha a táncos ügynök nem szerepel a virológus hatásai között az anoint hatásának lejárta után.

## Miért volt ez hasznos?

- Az elkészített unit tesztekkel külön-külön teszteltük a Game, Field és Virologist osztályokat, amelyek az anoint funkcionalitásáért felelősek. Ezáltal koncentráltunk ezekre a komponensekre, és kiküszöböltük a többi rész (pl. külső függőségek) befolyását.

- Az elkülönített tesztek izolált környezetben futnak, könnyűvé téve a hibák azonosítását és hibakeresését. A tesztek egyszerűen követhetőek, a hibák pedig gyorsan megtalálhatóak.

- A tesztek eredményeként megbizonyosodtunk a kód helyes működéséről. A pozitív teszteredmények azt jelentik, hogy a kód helyesen kezeli az anoint műveleteket a különböző viselkedések esetén.

- A tesztek segítségével pontosan megértettük az anoint funkcionalitását és az osztályok közötti interakciókat. Felfedeztük, hogy a viselkedések hogyan befolyásolják a hatásokat, és hogyan lehet ezeket a viselkedéseket külön-külön tesztelni és ellenőrizni.
