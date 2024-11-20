import React from 'react';
import { DataGrid } from "@mui/x-data-grid";
import Paper from '@mui/material/Paper';


const ActSchList = ({Titels, ActSchs}) => {

    const paginationModel = { page: 0, pageSize: 5 };

return (
    <Paper sx={{ height: 400, width: '100%' }}>
        <DataGrid
            rows={ActSchs}
            columns={Titels}
            initialState={{ pagination: { paginationModel } }}
            pageSizeOptions={[5, 10]}
            // checkboxSelection    // 勾選方框
            sx={{ border: 0 }}
        />
    </Paper>


    // <ul>
    // {ActSchs.map((ActSch) => (
    //     <ActSchItem
    //     key={ActSch.id}
    //     ActSch={ActSch}
    //     Titels={Titels}
    //     paginationModel={paginationModel}
    //     />
    // ))}
    // </ul>

);
};

export default ActSchList;