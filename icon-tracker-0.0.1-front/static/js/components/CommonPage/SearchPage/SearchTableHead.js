import React, {
    Component
} from 'react';
import {
    StatusHolder
} from 'components'
import {
    SEARCH_TYPE
} from 'utils/const'

class SearchTableHead extends Component {
    render() {
        const TableHead = () => {
            const {
                searchType
            } = this.props
            switch (searchType) {
                case SEARCH_TYPE.CONTRACTS:
                    return ( <
                        tr >
                        <
                        th > Address < /th> <
                        th > Contract Name < /th> { /* <th>Compiler</th> */ } <
                        th > Balance < /th> <
                        th > TxCount < /th> <
                        StatusHolder getData = {
                            this.props.getListByStatus
                        }
                        /> <
                        th > Confirmed date < /th> <
                        /tr>
                    )
                case SEARCH_TYPE.TOKENS:
                    return ( <
                        tr >
                        <
                        th > No. < /th> <
                        th > Token < /th> <
                        th > Price < /th> <
                        th > % Change(24 h) < /th> <
                        th > Volume(24 h) < /th> { /* <th className="marketcap"><span>MarketCap<em className="img"></em></span></th> */ } <
                        th > MarketCap < /th> <
                        /tr>
                    )
                default:
                    return ( <
                        tr > < /tr>
                    )
            }
        }

        return TableHead()
    }
}

export default SearchTableHead