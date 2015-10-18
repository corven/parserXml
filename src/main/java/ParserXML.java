import Model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class ParserXML {

    private ArrayList<String> params = new ArrayList<String>();
        int sizeRec = 0;
    private String fileName;

    public ParserXML(String fileName) {
        this.fileName = fileName;
    }

    public void out() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(fileName));
        NodeList nodeList = doc.getElementsByTagName("shapes");

        process("shapes", nodeList);
    }

    private void process(String name, NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) node;
                NodeList listChild = el.getChildNodes();
                if (el.getFirstChild().getNodeValue().contains("\n")) {
                    process(el.getTagName(), listChild);
                } else {
                    params.add(el.getTagName() + "_" + el.getTextContent());
                }
            }
        }
        params.add(name);
        calcArea(params);
        params.clear();
    }

    /**
     * Вычисление площади и ее вывод
     * @param allParam
     */
    private void calcArea(ArrayList<String> allParam) {
        String name = allParam.get(allParam.size() - 1);
        ArrayList<Double> calcParam = splitParam(name, allParam);
        if (name.equals("triangle")) {
            Triangle triangle = new Triangle(calcParam.get(0), calcParam.get(1), calcParam.get(2));
            triangle.calcArea();
            sizeRec++;
            System.out.println("<" + sizeRec + "> : <" + name + "> - <" + triangle.getArea() + ">");
        }else if (name.equals("circle")) {
            Circle circle = new Circle(calcParam.get(0));
            circle.calcArea();
            sizeRec++;
            System.out.println("<" + sizeRec + "> : <" + name + "> - <" + circle.getArea() + ">");
        }else if (name.equals("rhomb")) {
            Rhomb rhomb = new Rhomb(calcParam.get(0), calcParam.get(1));
            rhomb.calcArea();
            sizeRec++;
            System.out.println("<" + sizeRec + "> : <" + name + "> - <" + rhomb.getArea() + ">");
        }else if (name.equals("rect")) {
            Rect rect = new Rect(calcParam.get(0), calcParam.get(1));
            rect.calcArea();
            sizeRec++;
            System.out.println("<" + sizeRec + "> : <" + name + "> - <" + rect.getArea() + ">");
        }else if (name.equals("square")) {
            Square square = new Square(calcParam.get(0));
            square.calcArea();
            sizeRec++;
            System.out.println("<" + sizeRec + "> : <" + name + "> - <" + square.getArea() + ">");
        }else if (name.equals("ellipse")) {
            Ellipse ellipse = new Ellipse(calcParam.get(0), calcParam.get(1));
            ellipse.calcArea();
            sizeRec++;
            System.out.println("<" + sizeRec + "> : <" + name + "> - <" + ellipse.getArea() + ">");
        }else if (name.equals("trapezoid")) {
            Trapezoid trapezoid = new Trapezoid(calcParam.get(0), calcParam.get(1), calcParam.get(2));
            trapezoid.calcArea();
            sizeRec++;
            System.out.println("<" + sizeRec + "> : <" + name + "> - <" + trapezoid.getArea() + ">");
        }
    }

    /**
     * Разбиение параметров allParam
     * @param name
     * @param allParam
     * @return
     */
    private ArrayList<Double> splitParam(String name, ArrayList<String> allParam) {
        ArrayList<Double>  res   = new ArrayList<Double>(),
                          side   = new ArrayList<Double>(),
                          diag   = new ArrayList<Double>(),
                        height   = new ArrayList<Double>(),
                           rad   = new ArrayList<Double>();

        for (String strParam : allParam) {
            String[] sParam = strParam.split("_");
            if (strParam.contains("side")) {
                side.add(Double.valueOf(sParam[1]));
            }else if(strParam.contains("diagonal")) {
                diag.add(Double.valueOf(sParam[1]));
            }else if(strParam.contains("height")) {
                height.add(Double.valueOf(sParam[1]));
            }else if (strParam.contains("diameter")) {
                rad.add(Double.valueOf(sParam[1]) / 2);
            }else if(strParam.contains("radius")) {
                rad.add(Double.valueOf(sParam[1]));
            }
        }
        if (name.equals("triangle")) {
            return side;
        }else if (name.equals("circle")) {
            return rad;
        }else if (name.equals("rhomb")) {
            return diag;
        }else if (name.equals("rect")) {
            return side;
        }else if (name.equals("square")) {
            return side;
        }else if (name.equals("ellipse")) {
            return rad;
        }else if (name.equals("trapezoid")) {
            res.addAll(side);
            res.addAll(height);
            return res;
        }
        return res;
    }

}
