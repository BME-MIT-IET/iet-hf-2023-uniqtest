# 📈Statikus analízis

## SonarCloud

A projekt megvalósítása során a SonarCloud-ot választottuk, mint statikus analízis eszköz. 

Fontos volt, hogy a kódminőségén javítsak és szemléletesnek láttam a SonarCloud-ba használt jelentéseket, diagrammokat.
Integráltam még a build folyamatba is, így automatikusan generálódtak a jelentések.

## Elvégzett munka

Miután megkaptam az engedélyt volt lehetőség a SonarCloud-ot a projektbe integrálni. Először a pom.xml 'properties'-t egészítettem ki a megfelelő sonar.* tulajdonságokkal. A Secrets fülön hozzá kellett adnom a SonarCloud oldalon megjelenő SONAR_TOKEN titkot. Ekkor már volt maven konfigurációnk (maven.yml), amit kiegészítettem a megfelelő sorokkal. Így a build folyamatnak is része lett, generálódott jelentés is.

![SonarCloudBefore](/img/sonarcloud1.jpg)

## Eredmények

## Tanulságok
