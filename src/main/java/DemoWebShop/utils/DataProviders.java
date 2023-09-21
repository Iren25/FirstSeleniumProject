package DemoWebShop.utils;

import DemoWebShop.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> newUser() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[] {"Ronald1", "Smith", "smith016@gmail.com", "qwerty001", "qwerty001"});
        list.add(new Object[] {"Ronald2", "Smith", "smith014@gmail.com", "qwerty002", "qwerty002"});
        list.add(new Object[] {"Ronald3", "Smith", "smith015@gmail.com", "qwerty003", "qwerty003"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> newUserWithCSVFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/user.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User().setFirstname(split[0])
                    .setLastname(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])});
            line = reader.readLine();
        }

        return list.iterator();
    }
}
