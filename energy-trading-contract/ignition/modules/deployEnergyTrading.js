const { buildModule } = require("@nomicfoundation/hardhat-ignition/modules");

const deployEnergyTrading = buildModule("EnergyTradingDeployment", (m) => {
  const energyTrading = m.contract("EnergyTrading");

  return { energyTrading };
});

module.exports = deployEnergyTrading;