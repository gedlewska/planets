package com.example.katarzynagedlek.planets_01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "planets.db";
    private static final int DB_VERSION = 3;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE PLANETS" +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "DESCRIPTION TEXT," +
                "IMAGE_RESOURCE_ID INTEGER," +
                "READ NUMERIC);");

        insertPlanet(db, "Merkury", "Merkury (0,4 au) jest najbliższą Słońca i najmniejszą planetą (0,055 masy Ziemi). Merkury nie ma naturalnych satelitów, a jedyne znane jego cechy geologiczne oprócz kraterów uderzeniowych to obłe grzbiety i urwiska, prawdopodobnie powstałe w okresie kurczenia się jego stygnącego wnętrza we wczesnej historii planety. Merkury prawie w ogóle nie ma atmosfery, gdyż jest ona „zdmuchiwana” przez wiatr słoneczny. Nie wiadomo dokładnie jak ukształtowały się jego stosunkowo duże żelazne jądro i cienki płaszcz. Według części hipotez jego zewnętrzne warstwy zostały zdarte przez ogromne uderzenie i to spowodowało, że nie rozrósł się w pełni będąc pod wpływem promieniowania młodego Słońca.", R.drawable.merkury);
        insertPlanet(db, "Wenus", "Wenus (0,7 au) jest zbliżona rozmiarami do Ziemi (0,815 masy Ziemi) i podobnie jak ona, ma gruby płynny płaszcz wokół żelaznego jądra i masywną atmosferę, 90 razy gęstszą niż ziemska. Wenus nie ma naturalnych satelitów. Jest najgorętszą planetą, temperatura powierzchni osiąga powyżej 400 °C, z powodu dużej zawartości gazów cieplarnianych w atmosferze. Nie ma ona pola magnetycznego, które mogłoby zapobiec uszczupleniu jej gęstej atmosfery, co sugeruje, że atmosfera jest stale uzupełniana przez aktywność wulkaniczną. Nie ma jednak jak dotąd innych dowodów współczesnej aktywności geologicznej na Wenus.", R.drawable.wenus);
        insertPlanet(db, "Ziemia", "Ziemia (1 au) jest największą i najgęstszą z planet wewnętrznych, jedyną z pewnością aktywną geologicznie i jedyną znaną planetą, na której istnieje życie. Jej hydrosfera jest unikalna wśród planet skalistych. Jest także jedyną planetą gdzie została zaobserwowana tektonika płyt. Atmosfera ziemska jest odmienna od atmosfer pozostałych planet i jest wciąż kształtowana przez procesy biologiczne, dzięki którym zawiera 21% wolnego tlenu. Ma jednego naturalnego satelitę – Księżyc – jedynego dużego satelitę pośród planet skalistych w Układzie Słonecznym. Czasem wręcz określa się układ Ziemia-Księżyc jako planetę podwójną.", R.drawable.ziemia);
        insertPlanet(db, "Mars", "Mars (1,5 au) jest mniejszy niż Ziemia i Wenus (0,107 masy Ziemi). Ma rzadką atmosferę złożoną głównie z dwutlenku węgla. Jego powierzchnia jest usiana wieloma wulkanami takimi jak Olympus Mons i dolinami pochodzenia tektonicznego takimi jak Valles Marineris. Nie wiadomo, czy Mars wykazuje współcześnie aktywność geologiczną. Jego czerwona barwa pochodzi od gleby bogatej w tlenki żelaza. Mars ma dwa niewielkie księżyce: Fobosa i Deimosa. Mogą one być przechwyconymi planetoidami (przypominają je składem), lub mogły powstać na orbitach podobnych do dzisiejszych, na co wskazuje dynamika, np. z materii wyrzuconej przy uderzeniu dużego ciała w Marsa.", R.drawable.mars);
        insertPlanet(db, "Jowisz", "Jowisz (5,2 au) ma masę równą 318 mas Ziemi, czyli 2,5 razy więcej niż wszystkie pozostałe planety Układu. Składa się w większości z wodoru i helu. Duża ilość ciepła pochodząca z wnętrza planety tworzy wiele interesujących zjawisk w jego atmosferze, takich jak równoleżnikowe pasma chmur czy Wielka Czerwona Plama. Jowisz ma 67 znanych księżyców. Cztery największe z nich, tzw. księżyce galileuszowe, wykazują podobieństwa do planet skalistych, takie jak wulkanizm i zjawiska tektoniczne. Ganimedes, największy naturalny satelita w Układzie Słonecznym, jest większy niż Merkury.", R.drawable.jowisz);
        insertPlanet(db, "Saturn", "Saturn (9,5 au) słynie ze swoich szerokich i jasnych pierścieni. Pod względem budowy i składu atmosfery bardzo przypomina on Jowisza. Ma jednak bardzo małą gęstość; przy średnicy równej ok. 84% średnicy Jowisza jest ponad trzykrotnie mniej masywny. Ma 62 znane satelity. Największe spośród nich są zbudowane w dużym stopniu z lodu. Z tej grupy Tytan i Enceladus wykazują oznaki aktywności geologicznej (kriowulkanizm). Tytan jest większy niż Merkury i jest jedynym satelitą w Układzie Słonecznym, który ma gęstą atmosferę, w której zachodzą złożone zjawiska pogodowe; poza tym znajdują się na nim powierzchniowe zbiorniki (jeziora i morza) ciekłych węglowodorów. Ciśnienie atmosferyczne na jego powierzchni jest o ok. 47% większe niż na powierzchni Ziemi.", R.drawable.saturn);
        insertPlanet(db, "Uran", "Uran (19,6 au), przy masie 14 mas Ziemi, jest najlżejszą z planet-olbrzymów. Jego unikalną cechą jest to, że obiega Słońce „leżąc na boku”; jego oś obrotu jest nachylona do ekliptyki pod kątem bliskim 0°. Ma także znacznie mniej aktywne jądro i wypromieniowuje mniej ciepła niż pozostałe olbrzymy Uran ma 27 znanych księżyców (stan z 15 lipca 2013, spośród których największe to Tytania, Oberon, Umbriel, Ariel i Miranda).", R.drawable.uran);
        insertPlanet(db, "Neptun", "Neptun (30 au), chociaż nieco mniejszy od Urana, ma większą masę (równą 17 mas Ziemi) i większą gęstość. Wypromieniowuje też więcej ciepła, ale nie tak dużo jak Jowisz czy Saturn. Neptun ma 14 znanych księżyców. Największy z nich, Tryton, jest geologicznie aktywny, ma aktywne gejzery wyrzucające płynny azot. Tryton jest jedynym znanym dużym satelitą poruszającym się wokół swojej planety ruchem wstecznym – przeciwnym niż jej ruch wirowy.", R.drawable.neptun);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PLANETS");
        onCreate(db);
    }

    private static void insertPlanet(SQLiteDatabase db, String name, String description, int resourceId){
        ContentValues planetValues = new ContentValues();
        planetValues.put("NAME", name);
        planetValues.put("DESCRIPTION", description);
        planetValues.put("IMAGE_RESOURCE_ID", resourceId);
        planetValues.put("READ", 0);
        db.insert("PLANETS", null, planetValues);
    }


    public List<Planet> planetsList() {
        String query = "SELECT  _id, NAME, IMAGE_RESOURCE_ID, READ FROM PLANETS";

        List<Planet> planetLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Planet planet;

        if (cursor.moveToFirst()) {
            do {
                planet = new Planet();

                planet.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                planet.setName(cursor.getString(cursor.getColumnIndex("NAME")));
                planet.setImageResourceId(cursor.getInt(cursor.getColumnIndex("IMAGE_RESOURCE_ID")));
                planet.setRead(cursor.getInt(cursor.getColumnIndex("READ")) != 0);
                planetLinkedList.add(planet);
            } while (cursor.moveToNext());
        }

        return planetLinkedList;
    }

    public Planet getPlanet(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  * FROM PLANETS WHERE _id="+ id;
        Cursor cursor = db.rawQuery(query, null);

        Planet receivedPlanet = new Planet();
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();

            receivedPlanet.setName(cursor.getString(cursor.getColumnIndex("NAME")));
            receivedPlanet.setDescription(cursor.getString(cursor.getColumnIndex("DESCRIPTION")));
            receivedPlanet.setImageResourceId(cursor.getInt(cursor.getColumnIndex("IMAGE_RESOURCE_ID")));
            receivedPlanet.setRead(cursor.getInt(cursor.getColumnIndex("READ")) != 0);
        }

        return receivedPlanet;
    }

    public void updatePlanetRecord(int planetId, Context context, Planet updatedPlanet) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE PLANETS SET READ ='"+ (updatedPlanet.isRead() ? 1 : 0) + "'  WHERE _id='" + planetId + "'");
        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();
    }

}
