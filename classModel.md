```mermaid
    classDiagram

        class Bank{
            -accounts

            +requestAccount(name) Account
            +private addAccount(name)
            +private isValidAccount(name)
            +getAccount(name) ? might not be needed
        }

        class superClassAccount {
            -name
            -balance
            -bankstatements

            +deposit()
            +withdraw()
            +generateBankStatement()
            +getters()
            +private? setters()
        }

        class BankStatement{
            -date
            -credit
            -debit
            -balance of the time

            +getters()
            +setters()
            +toString()
        }

        class CurrentAccount{
        }

        class SavingsAccount{
        }

        class Customer{
            -accounts
            -name?

            +createCurrentAccount(name) Account
            +createSavingsAccount(name) Account
            +getAccount(name) Account
        }

        superClassAccount o-- BankStatement: has
        CurrentAccount o-- superClassAccount: extends
        SavingsAccount o-- superClassAccount: extends

        Bank o-- CurrentAccount: has
        Bank o-- SavingsAccount: has

        Bank o-- Customer: gives account
        Customer o-- Bank: request account


```
