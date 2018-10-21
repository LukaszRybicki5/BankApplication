package com.options;

import com.model.Client;
import java.util.List;
/*
Wybieramy zadanie do wykonania
 */
public interface OptionOnAccountSwitcher {
     void choosenOption(long AccountNumber, List<Client> clientList);
}
