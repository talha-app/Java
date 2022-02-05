package com.talha.springboot.app.controller;

import com.talha.springboot.app.entity.ClientInfo;
import com.talha.springboot.app.model.PostalCodeViewModel;
import com.talha.springboot.app.service.IClientInfoService;
import com.talha.springboot.app.service.IPostalCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/postalcodes")
public class PostalCodeRestController {
    @Autowired
    private IPostalCodeService m_postalCodeService;
    @Autowired
    private IClientInfoService m_clientInfoService;
    @Autowired
    private HttpServletRequest m_httpServletRequest;

    @GetMapping("/postalcodeJSON")
    public Iterable<PostalCodeViewModel> getPostalCodeJson(
            @RequestParam("code") String postalCode,
            @RequestParam(value = "country", required = false, defaultValue = "") String countryCode)
    {
        var hostAddr = m_httpServletRequest.getRemoteAddr();

        m_clientInfoService.save(new ClientInfo(hostAddr,
                postalCode,
                countryCode.isEmpty() ? "TR" : countryCode.toUpperCase()));

        return m_postalCodeService.getPostalCode(postalCode,
                countryCode);
    }

    @GetMapping(value = "/postalcodeXML", produces = MediaType.APPLICATION_XML_VALUE)
    public Iterable<PostalCodeViewModel> getPostalCodeXML(
            @RequestParam("code") String postalCode,
            @RequestParam(value = "country", required = false, defaultValue = "") String countryCode)
    {

        return getPostalCodeJson(postalCode,
                countryCode);
    }
}
