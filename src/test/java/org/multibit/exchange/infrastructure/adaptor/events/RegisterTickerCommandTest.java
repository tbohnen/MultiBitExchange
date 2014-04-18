package org.multibit.exchange.infrastructure.adaptor.events;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.multibit.exchange.infrastructure.adaptor.eventapi.CurrencyPairDescriptor;
import org.multibit.exchange.infrastructure.adaptor.eventapi.RegisterTickerCommand;
import org.multibit.exchange.testing.CurrencyFaker;

public class RegisterTickerCommandTest extends ExchangeAggregateRootTestBase {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  private CurrencyPairDescriptor currencyPairDescriptor;

  @Before
  public void setUp() {
    super.setUp();
    String baseCurrency = CurrencyFaker.createValid().getSymbol();
    String counterCurrency = CurrencyFaker.createValid().getSymbol();
    currencyPairDescriptor = new CurrencyPairDescriptor(baseCurrency, counterCurrency);
  }

  @Test
  public void test_Create() {
    // Arrange

    // Act
    new RegisterTickerCommand(exchangeId, currencyPairDescriptor.getTickerSymbol());

    // Assert
  }

  @Test
  public void test_Create_NullSecurityId() {
    // Arrange
    thrown.expect(NullPointerException.class);
    thrown.expectMessage("exchangeId must not be null");

    // Act
    new RegisterTickerCommand(null, currencyPairDescriptor.getTickerSymbol());

    // Assert
  }

  @Test
  public void test_Create_NullCurrencyPair() {
    // Arrange
    thrown.expect(NullPointerException.class);
    thrown.expectMessage("tickerSymbol must not be null");

    // Act
    new RegisterTickerCommand(exchangeId, null);

    // Assert
  }

}