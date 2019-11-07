package com.fangzhou.asongmanager.Service;

import com.fangzhou.asongmanager.dto.AuthorDTO;
import com.fangzhou.asongmanager.utils.Msg;

public interface AuthorService {
    Msg getAllAuthor(Integer pn);
    Msg delAuthor(Integer id);
    Msg SelAuthorBymohu(String username,Integer id);
    Msg SelAuthorById(Integer id);
    Msg UpdateAdmin(AuthorDTO authorDTO);
}
