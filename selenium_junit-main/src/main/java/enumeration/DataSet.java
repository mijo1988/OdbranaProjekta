package enumeration;

public enum DataSet {
    VERTICAL_MENU_PRODUCTS("Prenosni računari, Računari i komponente, Oprema za računare, Gaming, TV, audio, video, Mobilni telefoni i oprema, Bela tehnika, Prečišćivači vazduha, Mali kućni aparati, Sve za kuću, Fotoaparati i kamere, Sport i putovanje, Lifestyle, Muzički instrumenti i oprema, Kancelarijska oprema, Igračke, dečija i školska oprema, Alati i baštenska oprema, Izdvajamo iz ponude");

    private final String dataset;

    DataSet(String dataset) {
        this.dataset = dataset;
    }

    public String getDataset(){
        return dataset;
    }


}
