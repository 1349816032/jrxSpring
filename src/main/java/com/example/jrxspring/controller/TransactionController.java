package com.example.jrxspring.controller;

import com.example.jrxspring.model.DetailTransaction;
import com.example.jrxspring.model.ExtReturn;
import com.example.jrxspring.model.UserInformation;
import com.example.jrxspring.repository.DetailTransactionRepo;
import com.example.jrxspring.repository.UserInformationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZhaoYongfeng
 */
@Controller
@RequestMapping(path = "/transaction")
public class TransactionController {

    @Autowired
    private DetailTransactionRepo detailTransactionRepo;

    @Autowired
    private UserInformationRepo userInformationRepo;
    @GetMapping(path = "tran")
    public String transaction(){
        return "transaction";
    }

    @ResponseBody
    @GetMapping(path = "/showAll")
    @CrossOrigin
    public List<DetailTransaction> showAll(){
        final List<DetailTransaction> detailTransactions = detailTransactionRepo.queryAllDetailTransaction();
        return detailTransactions;
    }

    @PostMapping(path = "/showByCustId")
    @CrossOrigin
    @ResponseBody
    public ExtReturn showByCustId(@RequestParam (name = "cust_id") long CustId){
        final List<DetailTransaction> detailTransactions = detailTransactionRepo.queryFindByCustId(CustId);
        return new ExtReturn(true,detailTransactions,"");
    }

}
