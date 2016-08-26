package com.synergix.utilities;

import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import testng.page.actions.PageActions;
public class ReadBean
{
    public static String readFile(String fileName)
    {
        try
        {
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            String content = "";
            while ((s = br.readLine()) != null)
            {
                content += s + '\n';
            }
            br.close();
            return content;
        } catch (Exception e)
        {
            return ("</br>" + e.toString());
        }
    }

    public static String readLine(String fileName, int line)
    {
        return readFile(fileName).split("\n")[line - 1];
    }

    public static String readLastLine(String fileName)
    {
        String lines[] = readFile(fileName).split("\n");
        System.out.println(lines[lines.length - 1]);
        return lines[lines.length - 1];
    }

    public static int getLineNumber(String fileName, String lineValue)
    {
        String lines[] = readFile(fileName).split("\n");
        for (int i = 0; i < lines.length; i++)
        {
            if (lines[i].equals(lineValue))
            {
                return i + 1;
            }
        }
        return 0;
    }

    public static String getStringBetween(String text, String delimiter1, String delimiter2)
    {
        String result = "";
        Pattern p = Pattern.compile("\\" + delimiter1 + "(.*?)\\" + delimiter2 + "");
        Matcher m = p.matcher(text);
        while (m.find())
        {
            result += m.group(1);
        }
        return result;
    }

    public static String cutLastChar(String text, char delimeter)
    {
        return text.substring(0, text.indexOf(delimeter));
    }

    // When user abort a voucher, it should be deleted from file stack, previous
    // voucher will be in latest sequence
    public static void clearLastLine(String filePath)
    {
        RandomAccessFile file;
        try
        {
            file = new RandomAccessFile(filePath, "rw");
            long length = file.length() - 1;
            Byte b;
            Boolean isData = false, isDone = false;
            do
            {
                length -= 1;
                file.seek(length);
                b = file.readByte();
                if (b > 32)
                    isData = true;
                if (b == 10 && isData == true)
                    isDone = true;
                else if (b < 03)
                    isDone = true;
            } while (!isDone);
            file.setLength(length + 1);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String cutFirstChar(String text, char delimeter)
    {
        return text.substring(text.indexOf(delimeter) + 1, text.length()).trim();
    }

    public static String[] split(String text, String delimeter)
    {
        return text.split(delimeter);
    }

    public static void writeToFile(String filePath, String value)
    {
        writeToFile(filePath, value, false);
    }

    public static void writeToFile(String filePath, String value, boolean overwrite)
    {
        writeToFile(filePath, value, true, overwrite);
    }

    public static void writeToFile(String filePath, String value, boolean withTimeStamp, boolean overwrite)
    {
        try
        {
            PrintWriter out = new PrintWriter(new FileWriter(filePath, !overwrite));
            if (withTimeStamp)
                out.println(DateTimeUtil.getTimestamp() + " " + value + "\n");
            else
                out.println(value + "\n");
            out.close();
            System.out.println("Written: " + value + "\n");
        } catch (IOException e)
        {
        }
    }

    public static String getDatasetPathValue(String fileName, String lineName)
    {
        int lineNo = ReadBean.getLineNumber(fileName, lineName);
        String excelPath = ReadBean.readLine(fileName, lineNo + 1);
        return excelPath;
    }

    public static String addAlignedSpace(Object obj, int indent)
    {
        String value = "";
        if (obj == null)
        {
        }
        else if (obj instanceof Double || obj instanceof Integer)
        {
            value = String.valueOf(obj);
        }
        else
        {
            value = (String) obj;
        }
        StringBuilder sb = new StringBuilder(indent);
        for (int i = 0; i < indent; i++)
        {
            sb.append(" ");
        }
        String s = sb.toString();
        try
        {
            value += s.substring(0, s.length() - value.length());
        } catch (Exception e)
        {
        }
        return value;
    }

    public static void clearContent(String fileName)
    {
        PrintWriter pw = null;
        try
        {
            pw = new PrintWriter(fileName);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        pw.close();
    }

    public static void deleteFile(String fileName)
    {
        try
        {
            File file = new File(fileName);
            if (file.delete())
                System.out.println(file.getName() + " is deleted!");
            else
                System.out.println("Delete operation is failed.");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static String decodeBase64(String encodedStr)
    {
        // Decode data on other side, by processing encoded data
        byte[] valueDecoded = Base64.decodeBase64(encodedStr.getBytes());
        String value = new String(valueDecoded);
        System.out.println("Decoded value is " + value);

        return value;
    }

    /**
     * Check String is a number
     *
     * @author nancy
     */
    public static boolean isNumber(String value)
    {
        try
        {
            value = value.replace(",", "");
            double s = Double.parseDouble(value);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        } catch (NullPointerException ex)
        {
            return false;
        }
    }

    public static boolean equalsValue(String baseValue, String compareValue)
    {
        if (isNumber(baseValue) || isNumber(compareValue))
        {
            try
            {
                double baseInt = Double.parseDouble(baseValue);
                double compareInt = Double.parseDouble(compareValue);

                return baseInt == compareInt;
            } catch (NumberFormatException e)
            {
                return false;
            }
        }
        else
        {
            return baseValue.equalsIgnoreCase(compareValue);
        }
    }

    public static int toInt(Object value)
    {
        int i = 0;
        try
        {
            i = Integer.parseInt(value.toString());
        } catch (NumberFormatException e)
        {
            i = 0;
        }
        return i;
    }

    public static double toDouble(Object value)
    {
        double i = 0;
        try
        {
            String valueS = value.toString();
            valueS = valueS.replace(",", "");
            i = Double.parseDouble(valueS);
        } catch (NumberFormatException e)
        {
            i = 0;
        }
        return i;
    }

    public static boolean empty(String value)
    {
        try
        {
            if (value.equals("") || value.isEmpty())
                return true;
            else
                return false;
        } catch (Exception e)
        {
            return true;
        }
    }

    public static boolean notEmpty(String value)
    {
        try
        {
            if (!value.equals(""))
                return true;
            else
                return false;
        } catch (Exception e)
        {
            return false;
        }
    }

    public static boolean isUpperCase(String value)
    {
        try
        {
            if (value.equals(value.toUpperCase()))
                return true;
            else
                return false;
        } catch (Exception e)
        {
            return false;
        }
    }

    public static boolean equals(String valueA, String valueB)
    {
        try
        {
            return valueA.toLowerCase().equalsIgnoreCase(valueB.toLowerCase());
        } catch (Exception e)
        {
            return false;
        }
    }

    public static void writeLog(String filePath) throws FileNotFoundException
    {
        File file = new File(filePath);
        FileOutputStream fis = new FileOutputStream(file);
        PrintStream out = new PrintStream(fis);
        System.setOut(out);
    }

    /**
     * Round all number is double
     *
     * @param places is amount numbers after the dot.
     * @author nancy
     */
    public static String round(String number, int places)
    {
        if (isNumber(number))
        {
            double db = Double.parseDouble(number);
            String rs = String.format("%." + places + "f", db);
            return rs;
        }
        else
            return null;
    }

    public static String getPropValue(String propFile, String key)
    {
        Properties prop = new Properties();
        InputStream input = null;
        try
        {
            input = new FileInputStream(propFile);
            // load a properties file
            prop.load(input);
            return prop.getProperty(key);
        } catch (IOException ex)
        {
            ex.printStackTrace();
            return "";
        } finally
        {
            if (input != null)
            {
                try
                {
                    input.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void updateProp(String propFile, String key, String value, String comment)
    {
        try
        {
            FileInputStream in = new FileInputStream(propFile);
            Properties prop = new Properties();
            prop.load(in);
            in.close();

            FileOutputStream out = new FileOutputStream(propFile);
            prop.setProperty(key, value);
            prop.store(out, comment);
            out.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

//    // attachment for Allure Report
//    @Attachment(value = "{0}", type = "application/vnd.ms-excel")
//    public static byte[] attachXLS(String filePath)
//    {
//        try
//        {
//            File file = new File(filePath);
//            return toByteArray(file);
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    // attachment for Allure Report
//    @Attachment(type = "image/jpg")
//    public static byte[] attachJPG(String filePath)
//    {
//        try
//        {
//            File file = new File(filePath);
//            return toByteArray(file);
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return null;
//
//    }

    private static byte[] toByteArray(File file) throws IOException
    {
        return Files.readAllBytes(Paths.get(file.getPath()));
    }

    public static boolean isFile(String filePath)
    {
        try
        {
            return new File(filePath).isFile();
        } catch (Exception e)
        {
            return false;
        }
    }

    public static void copyFile(String fromS, String toS)
    {
        try
        {
            File from = new File(fromS);
            File to = new File(toS);
            new File(from.getParent()).mkdirs();
            new File(to.getParent()).mkdirs();
            Files.copy(from.toPath(), to.toPath());
        } catch (Exception e)
        {

        }
    }
}
