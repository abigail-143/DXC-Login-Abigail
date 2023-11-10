import React from 'react';

interface UserContextInterface {
    accessToken: string;
    setAccessToken: React.Dispatch<React.SetStateAction<string>>;
    username: string;
    setUsername: React.Dispatch<React.SetStateAction<string>>;
    clearance: string;
    setClearance: React.Dispatch<React.SetStateAction<string>>
}

const UserContext = React.createContext<UserContextInterface | undefined>(undefined);

export default UserContext;