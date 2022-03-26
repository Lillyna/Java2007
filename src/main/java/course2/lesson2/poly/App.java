package course2.lesson2.poly;

public class App {
    public static void main(String[] args) {
        Transport[] transports = new Transport[]{new Cater(), new Ship(), new Bus()};
        for(Transport transport:transports){
            transport.load();

            if(transport instanceof Swimable){
                System.out.println("Эта штука плывет");
                Swimable swimable = (Swimable) transport; //type-cast - приведение типа
                swimable.swim();
            }
            if(transport instanceof Bus){
                Bus bus = (Bus) transport;
                System.out.println(bus.getRoute());
            }
        }

        NewsService news = new OracleNewsServiceImpl();
        news.getNews();
    }


}
