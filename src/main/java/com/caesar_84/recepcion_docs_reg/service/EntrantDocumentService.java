package com.caesar_84.recepcion_docs_reg.service;

import com.caesar_84.recepcion_docs_reg.domain.model.EntrantDocument;
import com.caesar_84.recepcion_docs_reg.domain.model.ViewableEntrantDocument;
import com.caesar_84.recepcion_docs_reg.domain.repository.EntrantDocumentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class EntrantDocumentService {
    private EntrantDocumentService() {
    }

    private static EntrantDocumentService instance = null;

    private EntrantDocumentRepository repository = EntrantDocumentRepository.getInstance();

    public ViewableEntrantDocument get(int id) {
        return new ViewableEntrantDocument(repository.get(id));
    }

    public void save(ViewableEntrantDocument handedDocument) {
        repository.save(new EntrantDocument(handedDocument));
    }

    public void update(ViewableEntrantDocument handedDocument) {
        repository.update(new EntrantDocument(handedDocument));
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public ObservableList<ViewableEntrantDocument> getAll() {
        List<EntrantDocument> rawList = repository.getAll();

        return FXCollections.observableArrayList(rawList
                .stream()
                .map(ViewableEntrantDocument::new)
                .collect(Collectors.toList()));
    }

    public static EntrantDocumentService getInstance() {
        if (instance == null) {
            instance = new EntrantDocumentService();
        }

        return instance;
    }
}
