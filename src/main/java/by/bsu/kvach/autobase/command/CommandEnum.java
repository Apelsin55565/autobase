package by.bsu.kvach.autobase.command;

/**
 * Created by timme on 13.12.2016.
 */
public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    SIGNIN{
        {
            this.command = new SignInCommand();
        }
    },
    ALLDRIVERS{
        {
            this.command = new AllDriversCommand();
        }

    },
    REMOVEUSER{
        {
            this.command = new RemoveUserCommand();
        }
    },
    REMOVEAUTO{
        {
            this.command = new RemoveAutoCommand();
        }
    },
    ALLTRIP{
        {
            this.command = new AllTripCommand();
        }

    },

    REMOVETRIP{
        {
            this.command = new RemoveTripCommand();
    }
    },

    CREATENEWTRIP{
        {
            this.command = new CreateNewTripCommand();
        }
    },

    DRIVERSWITHOUTAUTO{
        {
            this.command = new DriversWithoutAutoCommand();
        }
    },


    DRIVERSWITHOUTTRIP{
        {
            this.command = new DriversWithoutTripCommand();
        }
    },


    CREATENEWAUTO{
        {
            this.command = new CreateNewAutoCommand();
        }
    },

    ALLAUTO{
        {
            this.command = new AllAutoCommand();
        }
    },

    USERAUTO{
        {
        this.command = new UserAutoCommand();
        }
    },
    UPDATEAUTOSTATUS{
        {
            this.command = new  UpdateAutoStatusCommand();
        }
    },

    UPDATETRIPSTATUS{
        {
            this.command = new UpdateTripStatusCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand(){
        return command;
    }
}