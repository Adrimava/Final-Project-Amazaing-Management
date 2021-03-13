export class EmployeeDTO {

    constructor(
        private _employeeName: string,
        private _photo: string,
        private _productivity: number,
        private _clumsiness: number,
        private _companyId: number,
        private _playerId: number
    ) { }

    public get playerId(): number {
        return this._playerId;
    }
    public set playerId(value: number) {
        this._playerId = value;
    }
    public get companyId(): number {
        return this._companyId;
    }
    public set companyId(value: number) {
        this._companyId = value;
    }
    public get clumsiness(): number {
        return this._clumsiness;
    }
    public set clumsiness(value: number) {
        this._clumsiness = value;
    }
    public get productivity(): number {
        return this._productivity;
    }
    public set productivity(value: number) {
        this._productivity = value;
    }
    public get photo(): string {
        return this._photo;
    }
    public set photo(value: string) {
        this._photo = value;
    }
    public get employeeName(): string {
        return this._employeeName;
    }
    public set employeeName(value: string) {
        this._employeeName = value;
    }

}
