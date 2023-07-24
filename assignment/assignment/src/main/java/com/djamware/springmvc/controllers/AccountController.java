
package com.djamware.springmvc.controllers;

import com.djamware.springmvc.models.account;
import com.djamware.springmvc.repositories.accountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
    
    @Autowired
    accountRepository accountRepository;

    @RequestMapping("/account")
    public String account(Model model) {
        model.addAttribute("account", accountRepository.findAll());
        return "account";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }

    @RequestMapping("/save")
    public String save(@RequestParam String accName, @RequestParam String accSurname, @RequestParam Double accImageData, @RequestParam String accImage) {
        account account= new account();
        account.setaccName(accName);
        account.setaccSurname(accSurname);
        account.setaccImageData(accImageData);
        account.setaccImage(accImage);
        accountRepository.save(account);

        return "redirect:/show/" + account.getId();
    }

    @RequestMapping("/show/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("account", accountRepository.findById(id).orElse(null));
        return "show";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Long id) {
        account account = accountRepository.findById(id).orElse(null);
        accountRepository.delete(account);

        return "redirect:/account";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("account", accountRepository.findById(id).orElse(null));
        return "edit";
    }

    @RequestMapping("/update")
    public String update(@RequestParam Long id, @RequestParam String accName, @RequestParam String accSurname, @RequestParam Double accImageData, @RequestParam String accImage) {
        account account = accountRepository.findById(id).orElse(null);
      account.setaccName(accName);
        account.setProdDesc(accSurname);
       account.setProdImage(accImageData);
        account.setProdPrice(accImage);
        accountRepository.save(account);

        return "redirect:/show/" + account.getId();
    }
    
}
