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

✅ A teszt sikeresnek tekinthető, ha a dancerAgent nem szerepel a virológus hatásai között az anoint hatásának lejárta után.

## KillTests

A játékban található "virologist" (virológusok) közötti "kill" műveleteket tesztelik. Az egyes tesztek különböző körülmények között ellenőrzik, hogy a "kill" művelet helyesen működik-e.

A tesztesetek előtt létrehozzuk magát a játékot, egy mezőt és két virológust, az egyik virológus a támadó a másik pedig az áldozat szerepet tölti be.

### __Tesztesetek:__

1️⃣ __KillBearWithAxeTest__

Ez a teszt ellenőrzi, hogy a virológus helyesen alkalmazza-e a kenést.

A teszt lépései:

1. Létrehoz egy új Axe-ot a támadó virológus részére.
2. Hozzáadja az axe objektumot az támadó felszereléseihez.
3. Beállítjuk a setKillBehaviour-t KillWithAxe viselkedésre.
4. Beáállítjuk a setMoveBehaviour-t BearMove viselkedésre.
5. Elvégzi az attacker.UseKill(victim) metódushívást, amely végrehajtja a támadást.


✅ A teszt sikeresnek tekinthető, ha az áldozat nem lesz jelen a field virológusokat tartalmazó listájában, az áldozat nem lesz jelen a game virológusokat tartalmazó listájában.
Az axe nem volt használva és a támadó objektum killBehaviorja a CantKill osztály.

2️⃣ __KillNormalPlayerWithAxe__:

Ez a teszt ellenőrzi, hogy a virológus tud-e ölni más virológust.

A teszt lépései:

1. Új Axe létrehozása és hozzáadása az equipments listához.
2. KillBehavior beállítása KillWithAxe-ra
3. Elvégzi az attacker.UseKill(victim) metódushívást, amely végrehajtja a támadást.

✅ A teszt sikeresnek tekinthető, ha az áldozat jelen van a field-en és az Axe használva volt.

3️⃣ __KillWhenCantKill__:

Az támadó virológusnak nincs lehetősége támadni (CantKill stratégia). Az elvárt eredmény az, hogy az áldozat objektum továbbra is jelen legyen a field és a game virológusokat tartalmazó listájában.

A teszt lépései:

1. Beállítjuk a virológus ölés stratégiáját a "CantKill"-re.
2. Elvégzi az attacker.UseKill(victim) metódushívást, amely végrehajtja a támadást.

✅ A teszt sikeresnek tekinthető, ha az áldozat továbbra is a mezőn tartózkodik.

## LabAndGencodeTests

A laboratórium mezőinek és a genetikai kódjainak működésének tesztelése. A LabAndGencodeTests osztályban deklarálódnak és inicializálódnak a szükséges objektumok. 

A setUp() metódus az objektumok inicializálását végzi.

A kódban négy teszteset található, amelyek a laboratórium mezőhöz tartozó genkódok beállítását és lekérését tesztelik. Az elvárt eredményeket ellenőrzik a assertEquals() metódus segítségével.


1️⃣ __setAlzheimerGencodeTest__

2️⃣ __setDancerGencodeTest__

3️⃣ __setParalyzingGencodeTest__

4️⃣ __setResistanceGencodeTest__

5️⃣ __LearnGencodeTest__

Ezen kívül, van egy LearnGencodeTest nevű teszteset is, amely a vírustudós genkód tanulását teszteli. A tesztben ellenőrzi, hogy a genkód sikeresen hozzáadódik-e a vírustudós genkódjainak listájához, és hogy a lista mérete 1.

## MoveTests

A Virologist osztály mozgásával kapcsolatos műveleteket teszteli.

A MoveTests osztályban deklarálódnak és inicializálódnak a szükséges objektumok. 

1️⃣ __putVirologistOnFieldTest__

2️⃣ __RemoveVirologistFromFieldTest__

A setUp() metódus az objektumok inicializálását végzi.

A kódban két teszteset található. Az egyik tesztesetben a putVirologistOnFieldTest() függvényben teszteli, hogy a neighbourField-en lévő új Virologist objektum sikeresen hozzáadódik-e a neighbourField virológusokat tartalmazó listájához.

✅ Az elvárt eredményt az assertEquals() metódus ellenőrzi.

A másik tesztesetben a RemoveVirologistFromFieldTest() függvényben tesztelik, hogy a field-ről sikeresen eltávolításra kerül-e a virologist objektum, és a field virológusokat tartalmazó listájának mérete 0 lesz-e. 

✅ Az elvárt eredményt az assertEquals() metódus ellenőrzi.

## ShelterAndEquipmentTests

Ezek a tesztesetek a menedék és a felszerelések helyes működését ellenőrzik a játékban.

### __Tesztesetek:__

1️⃣ __PickUpAnEquipmentWhenFullTest__

Ez a teszt ellenőrzi, hogy a virológus képes-e új felszerelést felvenni, ha már nincs az új felszerelésnek elegendő hely.

A teszt lépései:

1. Lekéri a felszerelések számát, mielőtt megpróbálkozik egy új felszerelést felvenni,
2. Hozzáadja az glove objektumot a felszereléseihez.


✅ A teszt sikeresnek tekinthető, ha a felszerelések száma nem változik az új felszerelés felvételével - azaz a glove felszerelést nem sikerült felvenni a virológusnak.


2️⃣ __PickUpAnEquipmentWhenNotFullTest__:

Ez a teszt ellenőrzi, hogy a virológus képes-e új felszerelést felvenni, ha van hely az új felszerelésnek.

A teszt lépései:

1. Virológus eldob egy kesztyűt a felszerelései közül.
2. Virológus felveszi a bag-et.

✅ A teszt sikeresnek tekinthető, ha a virológusok felszerelései között megtalálható a bag.

3️⃣ __PutDownAnEquipmentTest__:

Ez a teszt ellenőrzi, hogy a virológus képes-e felszerelést eldobni.

A teszt lépései:

1. Lekéri a felszerelések számát, mielőtt eldob egy felszerelést.
2. Eldobja a köppenyt.

✅ A teszt sikeresnek tekinthető, ha a felszerelések száma egyel kevesebb mint az eredeti felszerelés szám, a köppeny eldobása előtt.

## StealingTests

Ezek a tesztesetek a lopás műveleteket vizsgálják különböző helyzetekben.

### __Tesztesetek:__

1️⃣ __StealEquipmentFromNormalPlayerTest__

- Ellenőrzi, hogy az attacker felszerelést tud-e ellopni a victim-től, amikor a victim normál viselkedést mutat.
- Ellenőrzi, hogy a glove felszerelés továbbra is a victim-hoz tartozik, és a victim-nak van-e még a glove felszerelése.
- Ellenőrzi, hogy az attacker nem rendelkezik-e a glove felszereléssel.

✅ A teszt sikeresnek tekinthető, ha a fent említett 3 feltétel teljesül.

2️⃣ __StealEquipmentFromParalyzedPlayerTest__:

- Ellenőrzi, hogy az attacker felszerelést tud-e ellopni a victim-tól, amikor a victim bénult viselkedést mutat.
- Ellenőrzi, hogy a victim nem rendelkezik-e a glove felszereléssel.
- Ellenőrzi, hogy az attacker rendelkezik-e a glove felszereléssel.

✅ A teszt sikeresnek tekinthető, ha a fent említett 3 feltétel teljesül.

3️⃣ __StealSubstanceFromNormalPlayerTest__:

- Ellenőrzi, hogy az attacker anyagot tud-e ellopni a victim-tól, amikor a victim normál viselkedést mutat.
- Ellenőrzi, hogy a victim és az attacker aminó- és nukleotid értékei megfelelően módosulnak-e.


4️⃣ __MightBlockAnointTest__

- Ellenőrzi, hogy az attacker anyagot tud-e ellopni a victim-tól, amikor a victim bénult viselkedést mutat.
- Ellenőrzi, hogy a victim és az attacker aminó- és nukleotid értékei megfelelően módosulnak a különböző tesztesetekben.

## StorageFieldAndSubstanceTests

 Az osztály a StorageField és az aminó/nukleotid kezelését vizsgálja. Az osztályban található tesztek ellenőrzik a StorageField helyes beállításait, valamint azt, hogy a Virologist osztály megfelelően veszi fel az aminót és nukleotidot a Storage-ből.

### __Főbb tesztesetek:__

1️⃣ __PickUpAminoTest__

- Ellenőrzi, hogy a virológus sikeresen felvette-e a Storagen található Aminot.

✅ A teszt sikeresnek tekinthető, ha a fent említett feltétel teljesül.

2️⃣ __PickUpNucleotidTest__:

- Ellenőrzi, hogy a virológus sikeresen felvette-e a Storagen található Nukleotidot.

✅ A teszt sikeresnek tekinthető, ha a fent említett feltétel teljesül.

3️⃣ __PickUpSubstanceWithBagTest__:

Ez a teszt azt ellenőrzi, hogy a virológus a bag birtokában fel-e tud venni több anyagot.

A teszt lépései:

1. Új Bag objektum létrehozása és hozzáadása a virológus felszereléseihez.
2. Nukleotid felvétele.

✅ A teszt sikeresnek tekinthető, ha a virológus feltudta venni az összes nukleotidot.

## Miért volt ez hasznos?

- Az elkészített unit tesztekkel külön-külön teszteltük a Game, Field és Virologist osztályokat, amelyek az anoint funkcionalitásáért felelősek. Ezáltal koncentráltunk ezekre a komponensekre, és kiküszöböltük a többi rész (pl. külső függőségek) befolyását.

- Az elkülönített tesztek izolált környezetben futnak, könnyűvé téve a hibák azonosítását és hibakeresését. A tesztek egyszerűen követhetőek, a hibák pedig gyorsan megtalálhatóak.

- A tesztek eredményeként megbizonyosodtunk a kód helyes működéséről. A pozitív teszteredmények azt jelentik, hogy a kód helyesen kezeli az anoint műveleteket a különböző viselkedések esetén.

- A tesztek segítségével pontosan megértettük az anoint funkcionalitását és az osztályok közötti interakciókat. Felfedeztük, hogy a viselkedések hogyan befolyásolják a hatásokat, és hogyan lehet ezeket a viselkedéseket külön-külön tesztelni és ellenőrizni.