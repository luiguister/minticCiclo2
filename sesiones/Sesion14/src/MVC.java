public class MVC {
    
    public static void main(String ...args) {

        Model model = new Model();
        Model2 model2 = new Model2();
        View view = new View(model);
        View2 view2 = new View2(model2);
        Connect c = new Connect();
        Controller controller = new Controller(model, model2, view, view2, c);
        
        view.setVisible(true);
    }
}