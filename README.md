<center>
	<h2>
		Programowanie obiektowe <br>
		INEW0003P <br>
		Projekt
	</h2>


|      Wydział elektroniki       |  Kierunek: informatyka  |
|:-------------------------------|------------------------:|
| Grupa zajęciowa: Cz 17:05      | Semestr: 2019/2020 Lato |
| Nazwisko i Imię: Byczko Maciej | Nr indeksu: 252747      |
| Nazwisko i Imię: Maziec Michał | Nr indeksu: 252718      |
| Prowadzący:                    | mgr inż. Bogdan Gulowaty|
</center>

## Temat: Symulacja interakcji pomiędzy obiektami

<h4>
Ocena:<br>
Punkty:<br>
Data: <br>
</h4>

## Założenia i opis funkcjonalny programu

#### Założenia

Stworzenie prostej symulacji agentowej z wykorzystaniem technik projektowania obiektowego.<br>
Program modelujący wybrany wycinek rzeczywistości, a dokładniej obiekty i występujące pomiędzy nimi interakcje. Model ma być wprawiany w ruch wykorzystując generowane losowo zdarzenia, które zmuszają obiekty do rozmaitych działań.


## Analiza czasownikowo - rzeczownikowa

 Naszym zadaniem było zaprojektowanie prostej symulacji agentowej, w której badane jest zachowanie 
 <span style="color: cyan">ludzi</span> w czasie <span style="color: orange">rozprzestrzeniania się wirusa</span>. Dla uproszczenia symulacji przyjęliśmy, że <span style="color: cyan">ludzie</span> <span style="color: orange">zamieszkują</span> jednowymiarową przestrzeń o podanej wielkości, w której może dojść do <span style="color: orange">zarażenia się wirusem</span> przez styczność <span style="color: cyan">osób</span> w sąsiedztwie.

**Zachowania ludzi:**
- <span style="color: cyan">Ludzie</span> będą mogli <span style="color: orange">zmieniać swoje położenie</span> oraz będą <span style="color: orange">dążyli do izolacji</span>, by zmniejszyć szansę na <span style="color: orange">zarażenie się wirusem</span> i <span style="color: orange">chronić</span> inne <span style="color: cyan">osoby</span> przed rozprzestrzenieniem się zarazy. 

**Parametry symulacji:**
- Zadana wielkość mapy
- Liczba ludzi
- Szansa na zarażenie się
- Czas trwania pandemii (symulacja kończy się w chwili zarażenia lub wyleczenia całego społeczeństwa)
- Wykrycie zarażenia (boolean)
- Zachowanie dystansu przez danego człowieka


## Diagramy
#### Przypadki użycia
![UseCase](pictures/../Dokumentacja/pictures/usage%20diagram.png)

#### Klasy

![ClassDiagram](pictures/../Dokumentacja/pictures/diagram_main.png)

#### Karty CRC

![CRCcards](pictures/../Dokumentacja/pictures/CRC.PNG)

#### a Sequence Diagram

![SequenceDiagram](pictures/../Dokumentacja/pictures/Sequence_Diagram.png)
