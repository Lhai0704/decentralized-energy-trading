package com.energytrading.decentralized_energy_trading.service;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.crypto.Credentials;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

public class EthereumService {

    private Web3j web3j;
    private Credentials credentials;
    private StaticGasProvider gasProvider;

    public EthereumService() {
        // 1. 连接Hardhat的本地节点
        web3j = Web3j.build(new HttpService("http://localhost:8545"));  // Hardhat本地节点
        credentials = Credentials.create("your_private_key");  // Hardhat提供的账户私钥

        // 2. 设置Gas费
        gasProvider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
    }

    // 3. 加载已部署的智能合约
    public void loadContract(String contractAddress) {
        EnergyTrade contract = EnergyTrade.load(contractAddress, web3j, credentials, gasProvider);
        // 合约加载成功后可以调用智能合约的方法
    }
}

