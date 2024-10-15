# 去中心化能源交易
## Day 1
区块链基础设施搭建
1. 选择并设置区块链平台（Ethereum 或 Hyperledger Fabric）。
2. 编写和部署一个简单的智能合约。
3. 将区块链与Spring Boot项目集成，测试基本的交易功能。
   
以太坊的智能合约是用Solidity编写的，智能合约就是一种运行在区块链上的代码。对于能源交易平台，我们可以编写一个简单的合约来模拟能源的买卖。
安装hardhat
npm install --save-dev hardhat
初始化Hardhat项目
npx hardhat init
选择 Create a JavaScript project
安装项目依赖
npm install

Solidity开发环境：建议使用Remix IDE

编译合约
npx hardhat compile
生成合约的ABI和字节码，供后续部署和与合约交互使用

Hardhat有一个内置的以太坊节点，类似于Ganache。启动这个本地区块链：
npx hardhat node
启动一个本地以太坊网络，并且会生成一组测试账户供你使用