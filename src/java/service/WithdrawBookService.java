/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.WithdrawBookDAO;
import model.BankAccountDTO;
import model.SavingDTO;

/**
 *
 * @author NguyenDinhTien
 */
public class WithdrawBookService {
    public static SavingDTO getSaving(String numberSaving, String idcard){
        return WithdrawBookDAO.getSaving(numberSaving, idcard);
    }
}
