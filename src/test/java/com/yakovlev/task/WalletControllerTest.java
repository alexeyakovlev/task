package com.yakovlev.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yakovlev.task.controller.WalletController;
import com.yakovlev.task.model.Wallet;
import com.yakovlev.task.model.WalletDTO;
import com.yakovlev.task.service.WalletService;
import com.yakovlev.task.util.GlobalExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class WalletControllerTest {

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private WalletService walletService;

    @InjectMocks
    private WalletController walletController;

    private final UUID testUuid = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
    private final BigDecimal testAmount = BigDecimal.valueOf(1000);
    private final BigDecimal depositAmount = BigDecimal.valueOf(200);
    private final BigDecimal withdrawAmount = BigDecimal.valueOf(300);

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(walletController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @Test
    void getWalletById_ShouldReturnWallet() throws Exception {
        Wallet wallet = new Wallet(testUuid, testAmount);
        WalletDTO walletDTO = new WalletDTO(testUuid, testAmount);

        when(walletService.getById(testUuid)).thenReturn(walletDTO);

        mockMvc.perform(get("/api/v1/wallets/{WALLET_UUID}", testUuid))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(testUuid.toString()))
                .andExpect(jsonPath("$.amount").value(1000));
    }

    @Test
    void createWallet_ShouldCreateNewWallet() throws Exception {
        WalletDTO requestDto = new WalletDTO(testAmount);
        WalletDTO responseDto = new WalletDTO(testUuid, testAmount);

        when(walletService.save(any(WalletDTO.class))).thenReturn(responseDto);

        mockMvc.perform(post("/api/v1/wallet/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(testUuid.toString()))
                .andExpect(jsonPath("$.amount").value(1000));
    }


}