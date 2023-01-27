package mnViviendas;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafica extends JFrame{

    public Grafica() {
        CategoryDataset dataset= createDataset();
        
        JFreeChart chart = ChartFactory.createBarChart("Uso de Materiales Ecológicos", 
                "MATERIALES", 
                "PORCENTAJE",
                dataset, 
                PlotOrientation.VERTICAL,
                true, true, false
        );
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
      
    }
    private CategoryDataset createDataset(){
        DefaultCategoryDataset  dataset = new DefaultCategoryDataset();
        
        dataset.addValue(10, "1", "Cisterna");
        dataset.addValue(100, "2", "3R");
        dataset.addValue(50, "3", "Ilum. Iteligente");
        dataset.addValue(25, "4", "Luc. Ahorradores");
        dataset.addValue(12, "5", "Foco");
        return dataset;
    }
    
}