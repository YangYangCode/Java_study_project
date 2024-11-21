import React from 'react';
import { DataGrid } from "@mui/x-data-grid";
import Paper from '@mui/material/Paper';

const ActSchItem = ({ Titels, ActSch, paginationModel }) => {
    return (
        <li>
        <Paper sx={{ height: 400, width: '100%' }}>
            <DataGrid
                rows={ActSch}
                columns={Titels}
                initialState={{ pagination: { paginationModel } }}
                pageSizeOptions={[5, 10]}
                checkboxSelection
                sx={{ border: 0 }}
            />
        </Paper>
        </li>
    );
};

{/* <li>
<span>{ActSch.id}, </span>
<span>教室: {ActSch.room}　</span>
<span>講師: {ActSch.FitnessInstructor}　</span>
<span>課程: {ActSch.class}　</span>
<span>課程時間: {ActSch.classTime}　</span>
<span>人數: {ActSch.numberOfCanRegister}/{ActSch.numberOfHaveSigned}(人)　</span>




</li> */}

export default ActSchItem;

