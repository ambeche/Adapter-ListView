package com.example.listandadapters

object GlobalPresident {
    val presidents = ArrayList<President>()

    init {
        presidents.add ( President("Kaarlo Stahlberg", 1919, 1925, "First president"))
        presidents.add(President("Lauri Relander", 1925, 1931, "Second president"))
        presidents.add( President("P. E. Svinhufvud", 1931, 1937, "Third president"))
        presidents.add(President("Kyosti Kallio", 1937, 1940, "Fourth president"))
        presidents.add(President("Risto Ryti", 1940, 1944, "Firth president"))
        presidents.add(President("Carl Gustaf Emil Mannerheim", 1944, 1946, "Sixth president"))
        presidents.add(President("Juho Kusti Paasikivi", 1946, 1956, "Seventh president"))
        presidents.add(President("Urho Kekkonen", 1956, 1982, "Eighth president, Famous"))
        presidents.add(President("Mauno Koivisto", 1982, 1994, "Manu"))
        presidents.add(President("Martti Ahtisaari", 1994, 2000, "Mahtisaari"))
        presidents.add(President("Tarja Halonen", 2000, 2012, "First female president"))
        presidents.sort()
    }
}