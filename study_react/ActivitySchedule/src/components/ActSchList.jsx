import React from 'react';
import ActSchItem from './ActSchItem';

const ActSchList = ({ ActSchs }) => {
return (
    <ul>
    {ActSchs.map((ActSch) => (
        <ActSchItem
        key={ActSch.id}
        ActSch={ActSch}
        />
    ))}
    </ul>

);
};

export default ActSchList;