package com.jsonparser;

import com.model.Client;
import java.util.List;
/*
Interfejs tworzenia plików json
 */
public interface AccountFileMaker {
    void createFile(List<Client> clients);
}
